package com.endava.project.services.tools;

import com.endava.project.entities.Occurrence;
import com.endava.project.entities.Title;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * The generateTopWords gets the content of the article using the readFromURL method and then the methods from
 * FirstWordsGenerator in order to process the article and return the top words for the respective article.
 * The method puts the top words in a list of Occurrences which will be used futher to save them in the DB.
 */

public class SingleTitleProcess {

    private Title title;
    private List<Occurrence> list = new ArrayList<>();

    public SingleTitleProcess(Title title) {

        this.title = title;
    }

    public List<Occurrence> getList() {

        return list;
    }

    public void setList(List<Occurrence> list) {

        this.list = list;
    }

    public void generateTopWords() {
        FirstWordsGenerator firstWordsGenerator = new FirstWordsGenerator();
        ReadURL readURL = new ReadURL();

        String content = readURL.readFromURL(title.getName());
        Map<String, Integer> contentMap = firstWordsGenerator.findWordOccurrence(content);
        Map<String, Integer> sortedMap = firstWordsGenerator.sortTheWords(contentMap);
        Map<String, Integer> topWordsMap = firstWordsGenerator.wordsToBeSaved(sortedMap);

        Iterator it = topWordsMap.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            Occurrence occurrence = new Occurrence();
            occurrence.setWord((String) pair.getKey());
            occurrence.setOccurrences((Integer) pair.getValue());
            occurrence.setTitle(title);
            list.add(occurrence);
        }
    }
}
