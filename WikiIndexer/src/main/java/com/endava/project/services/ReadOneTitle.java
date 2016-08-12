package com.endava.project.services;

import com.endava.project.entities.Occurrence;
import com.endava.project.entities.Title;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by bsoimu on 8/12/2016.
 */

public class ReadOneTitle implements Runnable {

    private Title title;
    private static List<Occurrence> list = new ArrayList<>();

    public ReadOneTitle(Title title) {
        this.title = title;
    }

    public static List<Occurrence> getList() {
        return list;
    }

    public static void setList(List<Occurrence> list) {
        ReadOneTitle.list = list;
    }

    @Override
    public void run() {
        FirstWordsGenerator firstWordsGenerator = new FirstWordsGenerator();
        ReadURL readURL = new ReadURL();
        String content = readURL.readFromURL(title.getName());
        Map<String, Integer> map1 = firstWordsGenerator.findWordOccurrence(content);
        Map<String, Integer> map2 = firstWordsGenerator.sortTheWords(map1);
        Map<String, Integer> map3 = firstWordsGenerator.wordsToBeSaved(map2);

        Iterator it = map3.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            Occurrence occurrence = new Occurrence();
            occurrence.setWord((String) pair.getKey());
            occurrence.setOccurrences((Integer) pair.getValue());
            occurrence.setTitle(title);
            synchronized (list) {
                list.add(occurrence);
            }
        }
    }
}
