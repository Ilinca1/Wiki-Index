package com.endava.project.test;

import com.endava.project.services.tools.FirstWordsGenerator;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by ivamesu on 8/18/2016.
 */

public class FirstWordsGeneratorTest {

    private FirstWordsGenerator firstWordsGenerator;

    @Before
    public void findWordOccurrenceInitial() {
        firstWordsGenerator = new FirstWordsGenerator();
    }

    @Test
    public void findWordOccurrenceTest() {
        Map<String, Integer> map = firstWordsGenerator.findWordOccurrence("The village of Kyleakin is also" +
                " the site of Castle Moil(Kyleakin).");
        Map<String, Integer> fakeMap = new HashMap<>();
        fakeMap.put("kyleakin", 2);
        fakeMap.put("village", 1);
        fakeMap.put("site", 1);
        fakeMap.put("moil", 1);
        fakeMap.put("castle", 1);
        assertEquals(map, fakeMap);
    }

    @Test
    public void sortTheWordsTest() {

        Map<String, Integer> fakeMap = new HashMap<>();
        fakeMap.put("village", 1);
        fakeMap.put("site", 1);
        fakeMap.put("kyleakin", 2);
        fakeMap.put("moil", 1);
        fakeMap.put("castle", 1);
        Map<String, Integer> sortedMap = firstWordsGenerator.sortTheWords(fakeMap);
        assertEquals(sortedMap, fakeMap);
    }

    @Test
    public void wordsToBeSavedTest(){
        Map<String, Integer> fakeMap = new LinkedHashMap<>();

        fakeMap.put("village", 13);
        fakeMap.put("site", 12);
        fakeMap.put("kyleakin", 11);
        fakeMap.put("moil", 10);
        fakeMap.put("castle", 8);
        fakeMap.put("mom", 7);
        fakeMap.put("apple", 5);
        fakeMap.put("napkin", 2);
        fakeMap.put("cup", 1);
        fakeMap.put("building", 1);
        fakeMap.put("walk", 1);
        fakeMap.put("talk", 1);
        fakeMap.put("train", 1);
        fakeMap.put("sky", 1);
        fakeMap.put("pink", 1);
        Map<String,Integer> finalMap = firstWordsGenerator.wordsToBeSaved(fakeMap);

        Map<String, Integer> resultMap = new HashMap<>();

        resultMap.put("village", 13);
        resultMap.put("site", 12);
        resultMap.put("kyleakin", 11);
        resultMap.put("moil", 10);
        resultMap.put("castle", 8);
        resultMap.put("mom", 7);
        resultMap.put("apple", 5);
        resultMap.put("napkin", 2);
        resultMap.put("cup", 1);
        resultMap.put("building", 1);

        assertEquals(finalMap, resultMap);
    }


}
