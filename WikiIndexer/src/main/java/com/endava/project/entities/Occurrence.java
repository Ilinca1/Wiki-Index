package com.endava.project.entities;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "occurrence")
public class Occurrence {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name = "word")
    private String word;

    @Column(name = "occurrences")
    private int occurrences;

    @ManyToOne
    @JoinColumn(name = "title")
    private Title title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getOccurrences() {
        return occurrences;
    }

    public void setOccurrences(int occurrences) {
        this.occurrences = occurrences;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }
}
