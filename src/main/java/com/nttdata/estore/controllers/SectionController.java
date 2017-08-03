package com.nttdata.estore.controllers;
import com.nttdata.estore.entities.Section;
import com.nttdata.estore.repositories.SectionRepository;
import com.nttdata.estore.services.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/section")
public class SectionController {

    @Autowired
    private SectionService sectionService;
    @GetMapping(path="/allSections")
    public @ResponseBody Iterable<Section> getAllSections() {
        // This returns a JSON or XML with the users
        return sectionService.findAll();
    }
}