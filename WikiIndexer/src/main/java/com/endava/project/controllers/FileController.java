package com.endava.project.controllers;

import com.endava.project.entities.Occurrence;
import com.endava.project.services.impl.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by ivamesu on 8/17/2016.
 */
@RestController
public class FileController {

    @Autowired
    private MainService mainService;

    @RequestMapping(value = "/file", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Integer> uploadFile( MultipartFile file) {

        Map<String, Integer> map = new HashMap<>();
        try {
            map = mainService.showWordsForMultiTitles(file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

}
