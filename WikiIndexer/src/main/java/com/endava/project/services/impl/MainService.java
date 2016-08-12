package com.endava.project.services.impl;

import com.endava.project.entities.Occurrence;
import com.endava.project.entities.Title;
import com.endava.project.services.FirstWordsGenerator;
import com.endava.project.services.ReadURL;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by ivamesu on 8/11/2016.
 */
@Service
public class MainService {

    ReadURL readURL = new ReadURL();
    FirstWordsGenerator firstWordsGenerator = new FirstWordsGenerator();

    public List<Occurrence> sendInTheDB(Title title) {
        List<Occurrence> list = new ArrayList<>();

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
            list.add(occurrence);
        }
        return list;
    }


    public Map<String, Integer> showFromFile() {
        List<Occurrence> list = new ArrayList<>();

        Map<String, Integer> map1 = firstWordsGenerator.findWordOccurrenceMultiple("D:/Final Project/Wiki-Indexer/WikiIndexer/FisierTitluri.txt");
        Map<String, Integer> map2 = firstWordsGenerator.sortTheWords(map1);
        return firstWordsGenerator.wordsToBeSaved(map2);

    }
}
