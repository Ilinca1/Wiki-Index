package com.endava.project.services.impl;

import com.endava.project.services.tools.FirstWordsGenerator;
import com.endava.project.services.tools.ReadURL;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bsoimu on 8/18/2016.
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

        Map<String, Integer> map1 = firstWordsGenerator.findWordOccurrence(content);
        Map<String, Integer> map2 = firstWordsGenerator.sortTheWords(map1);
        finalMap = firstWordsGenerator.wordsToBeSaved(map2);
        System.out.println("done");
    }
}
