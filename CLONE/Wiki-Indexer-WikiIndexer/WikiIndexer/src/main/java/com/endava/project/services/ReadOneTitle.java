package com.endava.project.services;

import com.endava.project.entities.Title;

import java.util.Map;

/**
 * Created by bsoimu on 8/12/2016.
 */
public class ReadOneTitle extends Thread {

    private FirstWordsGenerator firstWordsGenerator;
    private ReadURL readURL;
    private Title title;

    @Override
    public void run() {
        String content = readURL.readFromURL(title.getName());
        Map<String, Integer> map1 = firstWordsGenerator.findWordOccurrence(content);
        Map<String, Integer> map2 = firstWordsGenerator.sortTheWords(map1);
        Map<String, Integer> map3 = firstWordsGenerator.wordsToBeSaved(map2);
    }
}
