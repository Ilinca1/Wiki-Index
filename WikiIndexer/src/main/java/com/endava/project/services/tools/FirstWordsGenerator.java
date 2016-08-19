package com.endava.project.services.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * This class has multiple methods used for the sorting of the words from an article or multiple articles.
 * The separator is used to split the words from the article and process them.
 * ignoreAll is a list of words to be ignored in the article in order to get a result that is relevant.
 * findWordOccurrence -> returns a map of the words using the content of an article.
 * sortTheWords -> gets a map of the words and their occurrences and returns it sorted
 *                 by the values of the map(occurrences of the words) and
 *                 maintains the insertion order using a LinkedList and a LinkedHashMap.
 * wordsToBeSaved -> gets a sorted map of words and returns only the first 10 elements.
 */

@Component
public class FirstWordsGenerator {

    private static final String separator = "(\\.|,|;|:|\\\\|/|\\?|~|`|<|>|\\[|]|\\{|}|\\(|\\)" +
            "|!|@|#|\\$|%|\\^|&|\\-|_|\\+|'|=|\\*|\"|\\|| |\\t|\\n|\\r)+";
    private static final List<String> ignoreAll = Arrays.asList("the", "of", "a", "and", "in", "to", "are",
            "as", "that", "is", "with", "for", "or", "they", "be", "on", "their", "have", "other", "used",
            "from", "can", "also", "such", "were", "an", "by", "which", "in", "this", "often", "even", "had",
            "has", "not", "been", "some", "it", "n", "many", "its", "s", "000", "nthe", "use", "frp", "but",
            "ten", "half", "de", "at", "was", "most", "1", "u2014", "u", "san", "u2013", "i", "ii", "k", "first",
            "u2019s", "c", "st","his", "her","he","she", "0", "2", "3", "4", "5", "6","7","8","9",
            "ten", "half", "de", "at", "was", "most", "1","u2014","u","san", "u2013", "u0103", "who", "0");


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


    public Map<String, Integer> sortTheWords(Map<String, Integer> map) {
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    public Map<String, Integer> wordsToBeSaved(Map<String, Integer> map) {
        Map<String, Integer> finalMap = new LinkedHashMap<>();
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
