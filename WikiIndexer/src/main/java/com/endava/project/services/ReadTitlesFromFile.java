package com.endava.project.services;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bsoimu on 8/12/2016.
 */
public class ReadTitlesFromFile implements Runnable {

    private static Map<String, Integer> finalMap = new HashMap<String, Integer>();

    public static Map<String, Integer> getFinalMap() {
        return finalMap;
    }

    public static void setFinalMap(Map<String, Integer> map3) {
        ReadTitlesFromFile.finalMap = map3;
    }

    @Override
    public void run() {
        FirstWordsGenerator firstWordsGenerator = new FirstWordsGenerator();

        Map<String, Integer> map1 = firstWordsGenerator.findWordOccurrenceMultiple("D:\\ProiectFinal\\CLONE\\Wiki-Indexer-WikiIndexer\\WikiIndexer\\FisierTitluri.txt");
        Map<String, Integer> map2 = firstWordsGenerator.sortTheWords(map1);
        synchronized (finalMap) {
            finalMap = firstWordsGenerator.wordsToBeSaved(map2);
        }
    }
}
