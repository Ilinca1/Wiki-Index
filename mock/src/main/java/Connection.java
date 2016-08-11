
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by bsoimu on 8/10/2016.
 */
public class Connection {
    static URL url;
    static HttpURLConnection conn;

    public static void main(String[] args){
        try {
            Map<String, Integer> map = new HashMap<String, Integer>();
            map =  findById("Snail");
            Iterator it = map.entrySet().iterator();
            int i = 0;
            while (it.hasNext() && i < 10) {
                Map.Entry pair = (Map.Entry) it.next();
                i++;
                System.out.println(pair.getKey() + ":" + pair.getValue());
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String,Integer> findById(String name) throws IOException {
        WordCounter wordCounter = new WordCounter();
        Map<String, Integer> map = new HashMap<String, Integer>();
        String str = null;
        try {
            url = new URL("https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&explaintext=&titles=" + name);
            conn = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    conn.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
              str = inputLine;
            }
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        map = wordCounter.generateMap(str);
        Map<String, Integer> sortedMapDesc = WordCounter.sortByComparator(map, false);
        return sortedMapDesc;
    }


}
