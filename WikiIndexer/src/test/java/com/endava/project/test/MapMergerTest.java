package com.endava.project.test;

import com.endava.project.services.tools.MapMerger;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by ivamesu on 8/18/2016.
 */
public class MapMergerTest {

    private MapMerger mapMerger;

    @Before
    public void mapMergerInitial() {
        mapMerger = new MapMerger();
    }

    @Test
    public void mapMergeTest() {
        Map<String, Integer> firstMap = new LinkedHashMap<>();

        firstMap.put("village", 13);
        firstMap.put("site", 12);
        firstMap.put("kyleakin", 11);
        firstMap.put("moil", 10);
        firstMap.put("castle", 8);

        Map<String, Integer> secondMap = new LinkedHashMap<>();

        secondMap.put("village", 13);
        secondMap.put("site", 12);
        secondMap.put("kyleakin", 11);
        secondMap.put("moil", 10);
        secondMap.put("castle", 8);

        Map<String, Integer> lastMap = new LinkedHashMap<>();

        lastMap.put("village", 26);
        lastMap.put("site", 24);
        lastMap.put("kyleakin", 22);
        lastMap.put("moil", 20);
        lastMap.put("castle", 16);

        Map<String, Integer> finalMap = new LinkedHashMap<>();

        finalMap = mapMerger.mapMerge(firstMap, secondMap);

        assertEquals(finalMap, lastMap);
    }
}
