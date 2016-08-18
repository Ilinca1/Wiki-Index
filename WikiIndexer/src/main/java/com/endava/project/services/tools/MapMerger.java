package com.endava.project.services.tools;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Merges two maps. In case there are duplicate words adds their values(occurrences)
 * in order not to lose occurrences for the respective words.
 */

@Component
public class MapMerger {

    public Map<String, Integer> mapMerge(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> returnMap = Stream.of(map1, map2)
                .map(Map::entrySet)
                .flatMap(Collection::stream)
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                Integer::sum
                        )
                );
        return returnMap;
    }
}
