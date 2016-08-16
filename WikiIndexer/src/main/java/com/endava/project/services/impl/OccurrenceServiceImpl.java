package com.endava.project.services.impl;

import com.endava.project.entities.Occurrence;
import com.endava.project.entities.Title;
import com.endava.project.repositories.OccurrenceRepository;
import com.endava.project.repositories.TitleRepository;
import com.endava.project.services.OccurrenceService;
import com.endava.project.services.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OccurrenceServiceImpl implements OccurrenceService {

    @Autowired
    private OccurrenceRepository occurrenceRepository;

    @Autowired
    private TitleRepository titleRepository;

    @Autowired
    private MainService mainService;

    @Override
    @Transactional
    public void saveOccurrence(String name) {

        Title title = titleRepository.findByName(name);

        for (Occurrence occurrence : mainService.sendInTheDB(title)) {
            occurrenceRepository.save(occurrence);
        }
    }

    @Override
    public List<Occurrence> findAllOccurrences(String name) {

        Title title = titleRepository.findByName(name);
        return occurrenceRepository.findByTitle(title.getId());

    }

}
