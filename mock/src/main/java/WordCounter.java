import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by ivamesu on 8/10/2016.
 */
public class WordCounter {

    public Map<String,Integer> generateMap(String string) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        Integer counter = 1;
        String[] words = string.split(" ");
        for (int i = 0; i < words.length; i++){
               counter = map.get(words[i]);
               if(counter == null)
                   counter = new Integer(0);
               map.put(words[i],counter+1);
        }
        return map;

    }
}

