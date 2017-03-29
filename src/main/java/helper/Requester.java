package helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Ayomitunde on 3/28/2017.
 */
public class Requester {
    public static String sendRequest(URL url)
    {
        try
        {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            int responseCode = connection.getResponseCode();
            if(responseCode != 200)
            {
                throw new RuntimeException("Failed: HTTP error code: "+responseCode);
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String result;
            StringBuilder stringBuilder = new StringBuilder();
            while((result = bufferedReader.readLine()) != null)
            {
                stringBuilder.append(result);
            }
            connection.disconnect();
            return stringBuilder.toString();
        }catch(MalformedURLException e)
        {
            e.printStackTrace();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
