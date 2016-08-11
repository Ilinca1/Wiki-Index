package com.endava.project.controllers;

import com.endava.project.services.OccurrenceService;
import com.endava.project.services.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TitleController {

    @Autowired
    private TitleService titleService;

    @Autowired
    private OccurrenceService occurrenceService;

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


}
