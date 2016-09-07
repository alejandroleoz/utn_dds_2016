package utn.dds.tp.datasource;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

/**
 * Created by aleoz on 9/6/16.
 */
public abstract class AbstractFuenteExterna implements FuenteExterna {

    protected JsonNode leerFuente(String url, Map<String, String> params) {
        StringBuffer query = new StringBuffer("?");

        // creo query string
        for (Map.Entry<String, String> entry : params.entrySet()) {
            query.append("&").append(entry.getKey()).append("=").append(entry.getValue());
        }

        try {
            URL myURL = new URL(url.concat(query.toString()));
            URLConnection myURLConnection = myURL.openConnection();

            BufferedReader in = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
            String inputLine;
            StringBuffer buffer = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                buffer.append(inputLine);
            }
            in.close();

            ObjectMapper mapper = new ObjectMapper();
            JsonNode actualObj = mapper.readTree(buffer.toString());
            return actualObj;

        } catch (MalformedURLException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
