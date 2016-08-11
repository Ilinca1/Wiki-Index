package com.endava.project.services;

import com.endava.project.entities.Title;

/**
 * Created by ivamesu on 8/11/2016.
 */
public interface TitleService {

    void saveTitle(String title);

    Title findByName(String name);
}
