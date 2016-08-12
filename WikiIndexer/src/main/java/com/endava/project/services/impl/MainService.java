package com.endava.project.services.impl;

import com.endava.project.entities.Occurrence;
import com.endava.project.entities.Title;
import com.endava.project.services.FirstWordsGenerator;
import com.endava.project.services.ReadOneTitle;
import com.endava.project.services.ReadTitlesFromFile;
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

    FirstWordsGenerator firstWordsGenerator = new FirstWordsGenerator();

    public List<Occurrence> sendInTheDB(Title title) {
        ReadOneTitle readOneTitle = new ReadOneTitle(title);
        readOneTitle.run();
        return readOneTitle.getList();
    }


    public Map<String, Integer> showFromFile() {
        ReadTitlesFromFile readTitlesFromFile = new ReadTitlesFromFile();
        readTitlesFromFile.run();
        return readTitlesFromFile.getFinalMap();
    }
}
