package com.endava.project.controllers;

import com.endava.project.dto.TitleDTO;
import com.endava.project.entities.Occurrence;
import com.endava.project.services.OccurrenceService;
import com.endava.project.services.TitleService;
import com.endava.project.services.impl.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
public class TitleController {

    @Autowired
    private TitleService titleService;

    @Autowired
    private OccurrenceService occurrenceService;

    @Autowired
    private MainService mainService;

    @RequestMapping(value = "/document", method = RequestMethod.GET)
    @ResponseBody
    public TitleDTO save(@RequestParam(name = "") String title) {
        List<Occurrence> list = null;
        TitleDTO titleDTO = new TitleDTO();

        if (titleService.findByName(title) == null) {
            Long before = System.currentTimeMillis();
            titleService.saveTitle(title);
            occurrenceService.saveOccurrence(title);
            list =  mainService.showWordsForSingleTitle(titleService.findByName(title));
            Long after = System.currentTimeMillis();
            titleDTO.setName(title);
            titleDTO.setWordsList(list);
            titleDTO.setSearchSource("Wikipedia");
            titleDTO.setSearchTime(after-before);
        } else {
            Long before = System.currentTimeMillis();
            list = occurrenceService.findAllOccurrences(title);
            Long after = System.currentTimeMillis();
            titleDTO.setName(title);
            titleDTO.setWordsList(list);
            titleDTO.setSearchSource("Database");
            titleDTO.setSearchTime(after-before);
        }

       return titleDTO;
    }

    @RequestMapping(value = "/file", method = RequestMethod.GET)
    @ResponseBody
    public void showWordsFromFile() {

        Iterator it = mainService.showWordsForMultiTitles().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

    }


}
