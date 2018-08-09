package com.example.hitesh.studentjsonactivity;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ParserDemo {

    String json;

    public String getDatajson(String student_URL){

        try {
            URL url =new URL(student_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedInputStream stream = new BufferedInputStream(connection.getInputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

            String line;
            StringBuffer buffer = new StringBuffer();

            while ((line =reader.readLine()) !=null){
                buffer.append(line);
            }

            json=buffer.toString();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;

    }

}
