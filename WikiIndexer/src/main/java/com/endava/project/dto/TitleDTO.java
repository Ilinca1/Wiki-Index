package com.endava.project.dto;

/**
 * Created by bsoimu on 8/16/2016.
 */
public class TitleDTO {

    private String name;

    private int searchTime;

    private String searchSource;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSearchTime() {
        return searchTime;
    }

    public void setSearchTime(int searchTime) {
        this.searchTime = searchTime;
    }

    public String getSearchSource() {
        return searchSource;
    }

    public void setSearchSource(String searchSource) {
        this.searchSource = searchSource;
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
