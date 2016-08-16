package com.endava.project.services.impl;

import com.endava.project.entities.Occurrence;
import com.endava.project.entities.Title;
import com.endava.project.services.*;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ivamesu on 8/11/2016.
 */
@Service
public class MainService {

    FirstWordsGenerator firstWordsGenerator = new FirstWordsGenerator();

    public List<Occurrence> sendInTheDB(Title title) {
        ReadOneTitle readOneTitle = new ReadOneTitle(title);
        readOneTitle.run();
        return readOneTitle.getList();
    }


    public Map<String, Integer> showFromFile() {
        FirstWordsGenerator firstWordsGenerator = new FirstWordsGenerator();
        MapMerger mapMerger = new MapMerger();
        FileReader fileReader = new FileReader();
        ArrayList<String> titles = fileReader.readFromFile
                ("D:/ProiectFinal/CLONE/Wiki-Indexer-WikiIndexer/WikiIndexer/FisierTitluri.txt");

        int threadTitlesSize = titles.size() / 4;

        ReadTitlesFromFile firstThread = new ReadTitlesFromFile(titles.subList(0, threadTitlesSize));
        ReadTitlesFromFile secondThread = new ReadTitlesFromFile(titles.subList(threadTitlesSize, 2 * threadTitlesSize));
        ReadTitlesFromFile thirdThread = new ReadTitlesFromFile(titles.subList(2 * threadTitlesSize, 3 * threadTitlesSize));
        ReadTitlesFromFile fourthThread = new ReadTitlesFromFile(titles.subList(3 * threadTitlesSize, titles.size()));

        Map<String, Integer> finalMap = new HashMap<>();

        Long before = System.currentTimeMillis();

        firstThread.run();
        finalMap.putAll(firstThread.getFinalMap());

        secondThread.run();
        finalMap = mapMerger.mapMerge(finalMap, secondThread.getFinalMap());

        thirdThread.run();
        finalMap = mapMerger.mapMerge(finalMap, thirdThread.getFinalMap());

        fourthThread.run();
        finalMap = mapMerger.mapMerge(finalMap, fourthThread.getFinalMap());

        Long after = System.currentTimeMillis();
        System.out.println("The time is : " + (after - before));

        finalMap = firstWordsGenerator.wordsToBeSaved(firstWordsGenerator.sortTheWords(finalMap));


        return finalMap;
    }
}
