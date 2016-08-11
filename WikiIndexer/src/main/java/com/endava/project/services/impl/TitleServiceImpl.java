package com.endava.project.services.impl;

import com.endava.project.entities.Title;
import com.endava.project.repositories.TitleRepository;
import com.endava.project.services.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ivamesu on 8/11/2016.
 */
@Service
public class TitleServiceImpl implements TitleService {

    @Autowired
    private TitleRepository titleRepository;


    @Override
    @Transactional
    public void saveTitle(String name) {
        Title title = new Title();
        title.setName(name);
        titleRepository.save(title);

    }

    @Override
    public Title findByName(String name) {
       return titleRepository.findByName(name);
    }


}
