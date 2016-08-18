package com.endava.project.services.tools;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;

/**
 * When a file is uploaded it's seen as a MultipartFile. The content of the file can be accessed
 * using an input stream, so the method readFromFile uses a inputStream as parameter that is sent
 * to a BufferedReader. In this way we can read each line of the file and return them into a list.
 */

@Component
public class FileReader {

    public ArrayList<String> readFromFile(InputStream inputStream) {

        ArrayList<String> titles = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            String data;
            while ((data = bufferedReader.readLine()) != null) {
                titles.add(data);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return titles;
    }
}
