package com.endava.project.services.impl;

import com.endava.project.entities.Occurrence;
import com.endava.project.entities.Title;
import com.endava.project.services.tools.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * showWordsForSingleTitle returns a list of Occurrence objects that will consist of the top 10 occurences in the
 * single article submitted.
 *
 * showWordsForMultiTitles returns a map that will consist of the top 10 words with their number of occurrences.
 * This map will contain all the contents from the multiple articles submitted using a Executor which makes sure that
 * every title will be processed by a thread and then its content added to the common map. At the end the map
 * is sorted and the top words are selected and returned.
 */

@Service
public class MainService {

    @Autowired
    FirstWordsGenerator firstWordsGenerator;

    @Autowired
    MapMerger mapMerger;

    @Autowired
    FileReader fileReader;

    public List<Occurrence> showWordsForSingleTitle(Title title) {
        SingleTitleProcess singleTitleProcess = new SingleTitleProcess(title);
        singleTitleProcess.generateTopWords();
        return singleTitleProcess.getList();
    }

    public Map<String, Integer> showWordsForMultiTitles(InputStream inputStream) {

        ArrayList<String> titles = fileReader.readFromFile(inputStream);

        Map<String, Integer> finalMap = new HashMap<>();

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for(String title : titles){
            MultiTitlesProcessExecutor multiTitlesProcessExecutor = new MultiTitlesProcessExecutor(title);
            Future future = executorService.submit(multiTitlesProcessExecutor);
            try {
                future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            finalMap = mapMerger.mapMerge(finalMap, multiTitlesProcessExecutor.getFinalMap());
        }

        finalMap = firstWordsGenerator.wordsToBeSaved(firstWordsGenerator.sortTheWords(finalMap));

        return finalMap;
    }
}
