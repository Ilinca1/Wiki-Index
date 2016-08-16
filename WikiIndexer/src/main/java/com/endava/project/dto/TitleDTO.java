package com.endava.project.dto;

import com.endava.project.entities.Occurrence;

import java.util.List;

/**
 * Created by bsoimu on 8/16/2016.
 */
public class TitleDTO {

    private String name;

    private long searchTime;

    private String searchSource;

    private List<Occurrence> wordsList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSearchTime() {
        return searchTime;
    }

    public void setSearchTime(long searchTime) {
        this.searchTime = searchTime;
    }

    public String getSearchSource() {
        return searchSource;
    }

    public void setSearchSource(String searchSource) {
        this.searchSource = searchSource;
    }

    public List<Occurrence> getWordsList() {
        return wordsList;
    }

    public void setWordsList(List<Occurrence> wordsList) {
        this.wordsList = wordsList;
    }

    @Override
    public String toString() {
        return "TitleDTO{" +
                "name='" + name + '\'' +
                ", searchTime=" + searchTime +
                ", searchSource='" + searchSource + '\'' +
                '}';
    }
}