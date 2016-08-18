package com.endava.project.controllers;

import com.endava.project.dto.TitleDTO;
import com.endava.project.entities.Occurrence;
import com.endava.project.services.OccurrenceService;
import com.endava.project.services.TitleService;
import com.endava.project.services.impl.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * This controller manages the DTO that is send into the UI and the data that is saved in the database.
 */

@RestController
public class ArticleController {

    @Autowired
    private TitleService titleService;

    @Autowired
    private OccurrenceService occurrenceService;

    @Autowired
    private MainService mainService;

    /**
     * Check if the title is in the database:
     * - if the title is not in the database is inserted + the occurrences and the search time is saved in the DTO
     * - if the title is in the database -> gets the information from the database and search time is saved in the DTO
     *
     * @param title
     * @return TitleDTO
     */
    @RequestMapping(value = "/document", method = RequestMethod.GET)
    @ResponseBody
    public TitleDTO save(@RequestParam(name = "") String title) {
        List<Occurrence> list = null;
        TitleDTO titleDTO = new TitleDTO();

        if (titleService.findByName(title) == null) {
            Long before = System.currentTimeMillis();
            titleService.saveTitle(title);
            occurrenceService.saveOccurrence(title);
            list = mainService.showWordsForSingleTitle(titleService.findByName(title));
            Long after = System.currentTimeMillis();
            titleDTO.setName(title);
            titleDTO.setWordsList(list);
            titleDTO.setSearchSource("Wikipedia");
            titleDTO.setSearchTime(after - before);
        } else {
            Long before = System.currentTimeMillis();
            list = occurrenceService.findAllOccurrences(title);
            Long after = System.currentTimeMillis();
            titleDTO.setName(title);
            titleDTO.setWordsList(list);
            titleDTO.setSearchSource("Database");
            titleDTO.setSearchTime(after - before);
        }

        return titleDTO;
    }
}



