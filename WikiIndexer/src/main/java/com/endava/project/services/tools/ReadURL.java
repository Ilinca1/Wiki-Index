package com.endava.project.services.tools;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * This method uses a Wiki API which returns the article as a JSON. The JSON is read using a BufferedReader
 * for input streams.
 */
@Component
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
