package com.endava.project.services.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by ivamesu on 8/11/2016.
 */
public class ReadURL {

    static URL url;
    static HttpURLConnection conn;

    public String readFromURL(String name) {
        String str = null;
        String inputLine;
        try {
            url = new URL("https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&explaintext=&titles=" + name);
            conn = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    conn.getInputStream()));
            while ((inputLine = in.readLine()) != null) {
                str = inputLine;
            }
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
