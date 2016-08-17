package com.endava.project.services.tools;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by bsoimu on 8/13/2016.
 */

public class FileReader {

    public ArrayList<String> readFromFile(InputStream inputStream) {
        ArrayList<String> titles = new ArrayList<>();
        //  Reader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            //   fileReader = new java.io.FileReader(fileName);
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String data;
            while ((data = bufferedReader.readLine()) != null) {
                titles.add(data);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return titles;
    }
}
