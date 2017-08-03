package com.nttdata.estore.controllers;

import com.nttdata.estore.entities.Section;
import com.nttdata.estore.services.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/section")
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @GetMapping(path = "/allSections")
    public @ResponseBody
    Iterable<Section> getAllSections() {
        return sectionService.findAll();
    }
}