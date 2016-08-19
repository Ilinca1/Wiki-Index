package com.endava.project.test;

import com.endava.project.entities.Occurrence;
import com.endava.project.entities.Title;
import com.endava.project.services.impl.MainService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by ivamesu on 8/18/2016.
 */
public class MainServiceTest {

    private MainService mainService;
    private Title title;

    @Before
    public void initial() {
        mainService = new MainService();
        title = new Title();
    }

    @Test
    public void showWordsForSingleTitleTest() {
        List<Occurrence> lastList = new ArrayList<>();
        title.setName("Snail");
        Occurrence occurrence1 = new Occurrence();
        occurrence1.setTitle(title);
        occurrence1.setWord("snails");
        occurrence1.setOccurrences(38);

        Occurrence occurrence2 = new Occurrence();
        occurrence2.setTitle(title);
        occurrence2.setWord("snail");
        occurrence2.setOccurrences(25);

        Occurrence occurrence3 = new Occurrence();
        occurrence3.setTitle(title);
        occurrence3.setWord("species");
        occurrence3.setOccurrences(17);

        Occurrence occurrence4 = new Occurrence();
        occurrence4.setTitle(title);
        occurrence4.setWord("shell");
        occurrence4.setOccurrences(14);

        Occurrence occurrence5 = new Occurrence();
        occurrence5.setTitle(title);
        occurrence5.setWord("land");
        occurrence5.setOccurrences(14);

        lastList.add(occurrence1);
        lastList.add(occurrence2);
        lastList.add(occurrence3);
        lastList.add(occurrence4);
        lastList.add(occurrence5);

        List<Occurrence> list = mainService.showWordsForSingleTitle(title).subList(0, 5);

        assertTrue(list.get(0).equals(lastList.get(0)) &&
                list.get(1).equals(lastList.get(1)) &&
                list.get(2).equals(lastList.get(2)) &&
                list.get(3).equals(lastList.get(3)) &&
                list.get(4).equals(lastList.get(4)));
    }
}
