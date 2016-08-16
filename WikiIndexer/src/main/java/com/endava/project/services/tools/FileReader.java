package com.endava.project.services.tools;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

/**
 * Created by bsoimu on 8/13/2016.
 */

public class FileReader {

    public ArrayList<String> readFromFile(String fileName) {
        ArrayList<String> titles = new ArrayList<>();
        Reader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new java.io.FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);
            String data;
            while ((data = bufferedReader.readLine()) != null) {
                titles.add(data);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File missing '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("I/O Exception:" + ex.getMessage());
        } finally {
            System.out.println("---");
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException ex) {
                System.out.println("I/O Exception:" + ex.getMessage());
            }
        }

        return titles;
    }
}
