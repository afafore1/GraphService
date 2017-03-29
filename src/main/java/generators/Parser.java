package generators;

import com.sun.codemodel.JCodeModel;
import org.jsonschema2pojo.*;
import org.jsonschema2pojo.rules.RuleFactory;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;

/**
 * Created by Ayomitunde on 2/10/2017.
 */
public class Parser {
    private static final String SCHEMA_DIR = "schemas/";
    private static final String CLASS_DATA_DIR = "classData/";
    private static HashSet<File> JSON_FILES;
    private static HashSet<File> DATA_FILES;
    private static JCodeModel codeModel = new JCodeModel();
    static
    {
        JSON_FILES = getFiles(Parser.class, SCHEMA_DIR);
        DATA_FILES = getFiles(Parser.class, CLASS_DATA_DIR);
    }


    private static HashSet<File> getFiles(Class<?> passedInClass, String dir)
    {
        HashSet<File> files = new HashSet<>();
        ClassLoader classLoader = passedInClass.getClassLoader();
        File folder = new File(classLoader.getResource(dir).getFile());
        File [] listOfFiles = folder.listFiles();
        for(File f : listOfFiles)
        {
            files.add(f);
        }
        return files;
    }

    public static HashSet<File> getDataFiles()
    {
        return DATA_FILES;
    }

    protected static void generateJavaClasses() throws IOException {
        for(File f : JSON_FILES)
        {
            String fileName = f.getName();
            String className = fileName.substring(0, fileName.indexOf("."));
            String packageName = "com.algorithms.graph";
            generateJavaClasses(className, packageName, f.toURI().toURL());
        }
    }

    private static void generateJavaClasses(String className, String packageName, URL source) throws IOException
    {
        GenerationConfig config = new DefaultGenerationConfig()
        {
            @Override
            public boolean isGenerateBuilders()
            {
                return true;
            }
        };
        SchemaMapper mapper = new SchemaMapper(new RuleFactory(config, new Jackson2Annotator(config), new SchemaStore()), new SchemaGenerator());
        mapper.generate(codeModel, className, packageName, source);
        codeModel.build(new File("./src/main/java/"));
    }
}
