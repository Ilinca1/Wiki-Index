package com.endava.project.services.tools;

import java.util.HashMap;
import java.util.Map;

/**
 * This runnable uses the methods from FirstWordsGenerator. It is used only when a file with multiple titles will
 * be uploaded to the UI. Each title will be assigned to a thread that will process it and return the map of words
 * that will be used in determining the top words for all the titles.
 */

public class MultiTitlesProcessExecutor implements Runnable {
    private String title;
    private Map<String, Integer> finalMap;

    public MultiTitlesProcessExecutor(String title) {
        finalMap = new HashMap<>();
        this.title = title;
    }

    public Map<String, Integer> getFinalMap() {
        return finalMap;
    }

    public void setFinalMap(Map<String, Integer> finalMap) {
        this.finalMap = finalMap;
    }

    public void run(){
        FirstWordsGenerator firstWordsGenerator = new FirstWordsGenerator();
        ReadURL readURL = new ReadURL();

        String content = readURL.readFromURL(title);

        Map<String, Integer> contentMap = firstWordsGenerator.findWordOccurrence(content);
        Map<String, Integer> sortedMap = firstWordsGenerator.sortTheWords(contentMap);
        finalMap = firstWordsGenerator.wordsToBeSaved(sortedMap);

        System.out.println("done");
    }
}
