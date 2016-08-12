import java.util.*;

/**
 * Created by ivamesu on 8/10/2016.
 */
public class WordCounter {

    public Map<String, Integer> generateMap(String string) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        Integer counter = 1;
//        String separator = "\\s+|\\W+\\s";
        String separator2 = "(\\.|,|;|:|\\\\|/|\\?|~|`|<|>|\\[|]|\\{|}|\\(|\\)" +
                "|!|@|#|\\$|%|\\^|&|\\-|_|\\+|'|=|\\*|\"|\\|| |\\t|\\n|\\r)+";
        List<String> ignoreAll= Arrays.asList("the", "of", "a", "and", "in", "to", "are", "as", "that",
                "is", "with", "for", "or", "they", "be", "on", "their", "have", "other", "used", "from",
                "can", "also", "such", "were", "an", "by", "which", "in", "this", "often", "even", "had",
                "has", "not", "been", "some", "it", "n", "many", "its");

        String[] words = string.split(separator2);
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].toLowerCase();
            if(!ignoreAll.contains(words[i])) {
                counter = map.get(words[i]);
                if (counter == null)
                    counter = new Integer(0);
                map.put(words[i], counter + 1);
            }
        }

        return map;
    }


    public static Map<String, Integer> sortByComparator(Map<String, Integer> map, final boolean order) {
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());

        // Sorting the list based on values
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                if (order) {
                    return o1.getValue().compareTo(o2.getValue());
                } else {
                    return o2.getValue().compareTo(o1.getValue());
                }
            }
        });

        // Maintaining insertion order with the help of LinkedList
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
}