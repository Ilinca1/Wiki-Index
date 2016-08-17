package com.endava.project.services.impl;

import com.endava.project.entities.Occurrence;
import com.endava.project.entities.Title;
import com.endava.project.services.tools.*;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.*;

/**
 * Created by ivamesu on 8/11/2016.
 */
@Service
public class MainService {

    public List<Occurrence> showWordsForSingleTitle(Title title) {
        SingleTitleProcess singleTitleProcess = new SingleTitleProcess(title);
        singleTitleProcess.generateTopWords();
        return singleTitleProcess.getList();
    }


    public Map<String, Integer> showWordsForMultiTitles(InputStream inputStream) {

        FirstWordsGenerator firstWordsGenerator = new FirstWordsGenerator();
        MapMerger mapMerger = new MapMerger();
        FileReader fileReader = new FileReader();
        ArrayList<String> titles = fileReader.readFromFile(inputStream);

        int threadTitlesSize = titles.size() / 4;

        MultiTitlesProcess firstThread = new MultiTitlesProcess(titles.subList(0, threadTitlesSize));
        MultiTitlesProcess secondThread = new MultiTitlesProcess(titles.subList(threadTitlesSize, 2 * threadTitlesSize));
        MultiTitlesProcess thirdThread = new MultiTitlesProcess(titles.subList(2 * threadTitlesSize, 3 * threadTitlesSize));
        MultiTitlesProcess fourthThread = new MultiTitlesProcess(titles.subList(3 * threadTitlesSize, titles.size()));

        Map<String, Integer> finalMap = new HashMap<>();

        firstThread.run();
        finalMap.putAll(firstThread.getFinalMap());

        secondThread.run();
        finalMap = mapMerger.mapMerge(finalMap, secondThread.getFinalMap());

        thirdThread.run();
        finalMap = mapMerger.mapMerge(finalMap, thirdThread.getFinalMap());

        fourthThread.run();
        finalMap = mapMerger.mapMerge(finalMap, fourthThread.getFinalMap());

        finalMap = firstWordsGenerator.wordsToBeSaved(firstWordsGenerator.sortTheWords(finalMap));

        return finalMap;
    }
}
