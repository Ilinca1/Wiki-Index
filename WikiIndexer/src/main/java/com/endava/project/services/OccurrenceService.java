package com.endava.project.services;

import com.endava.project.entities.Occurrence;

import java.util.List;

/**
 * Created by ivamesu on 8/11/2016.
 */
public interface OccurrenceService {

    void saveOccurrence(String title);

    List<Occurrence> findAllOccurrences(String title);
}
