package generators;

import java.io.IOException;

/**
 * Created by Ayomitunde on 2/10/2017.
 */
public class Test {
    public static void main(String [] args)
    {
        try {
            Parser.generateJavaClasses();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
