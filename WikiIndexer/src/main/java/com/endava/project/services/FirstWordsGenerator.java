package com.endava.project.services;

import java.util.*;
import java.io.*;

public class FirstWordsGenerator {

    private static final String separator = "(\\.|,|;|:|\\\\|/|\\?|~|`|<|>|\\[|]|\\{|}|\\(|\\)" +
            "|!|@|#|\\$|%|\\^|&|\\-|_|\\+|'|=|\\*|\"|\\|| |\\t|\\n|\\r)+";
    private static final List<String> ignoreAll = Arrays.asList("the", "of", "a", "and", "in", "to", "are", "as", "that",
            "is", "with", "for", "or", "they", "be", "on", "their", "have", "other", "used", "from",
            "can", "also", "such", "were", "an", "by", "which", "in", "this", "often", "even", "had",
            "has", "not", "been", "some", "it", "n", "many", "its", "s", "000", "nthe", "use", "frp", "but",
            "ten", "half", "de", "at", "was", "most", "1");
    private ReadURL readURL = new ReadURL();

    public Map<String, Integer> findWordOccurrence(String text) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        Integer counter = 1;

        String[] words = text.split(separator);
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].toLowerCase();
            if (!ignoreAll.contains(words[i])) {
                counter = map.get(words[i]);
                if (counter == null)
                    counter = new Integer(0);
                map.put(words[i], counter + 1);
            }
        }

        return map;
    }

    public Map<String, Integer> findWordOccurrenceMultiple(List<String> titles) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        Integer counter = 1;

        for (int i = 0; i < titles.size(); i++) {
            String content = readURL.readFromURL(titles.get(i));
            String[] words = content.split(separator);
            for (int j = 0; j < words.length; j++) {
                words[j] = words[j].toLowerCase();
                if (!ignoreAll.contains(words[j])) {
                    counter = map.get(words[j]);
                    if (counter == null)
                        counter = new Integer(0);
                    map.put(words[j], counter + 1);
                }
            }
        }

        return map;
    }

    //Sorteaza mapul dupa cele mai multe aparitii
    public Map<String, Integer> sortTheWords(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
        // Sorting the list based on values
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        // Maintaining insertion order with the help of LinkedList
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    //primeste o lista sortata si pastreaza primele 10 elemente
    public Map<String, Integer> wordsToBeSaved(Map<String, Integer> map) {
        Map<String, Integer> finalMap = new HashMap<>();
        Iterator it = map.entrySet().iterator();
        int i = 0;
        while (it.hasNext() && i < 10) {
            Map.Entry pair = (Map.Entry) it.next();
            i++;
            finalMap.put((String) pair.getKey(), (Integer) pair.getValue());
        }

        return finalMap;
    }

}
