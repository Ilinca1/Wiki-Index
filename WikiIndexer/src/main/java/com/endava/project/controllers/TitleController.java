package com.endava.project.controllers;

import com.endava.project.services.OccurrenceService;
import com.endava.project.services.TitleService;
import com.endava.project.services.impl.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
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
    public void save(@RequestParam(name = "title") String title) {


        if (titleService.findByName(title) == null) {
            titleService.saveTitle(title);
            occurrenceService.saveOccurrence(title);
        } else{
            System.out.println("Deja e in baza de date!");
        }

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
