package com.nttdata.estore.controllers;

import com.nttdata.estore.entities.Section;
import com.nttdata.estore.services.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@RestController
@CrossOrigin

public class SectionController {

    @Autowired
    private SectionService sectionService;

    @GetMapping(path = "/sections")
    public @ResponseBody
    Iterable<Section> getAllSections() {
        return sectionService.findAll();
    }

    @GetMapping(path = "/sections/{id}")
    public ResponseEntity getSection(@PathVariable("id") int id) {
        Section section = sectionService.getSection(id);
        if (section == null) {
            return new ResponseEntity("No Section found for ID " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(section, HttpStatus.OK);
    }

    @DeleteMapping(path = "/sections/{id}")
    public ResponseEntity deleteSection(@PathVariable int id) {
        sectionService.deleteSection(id);
        return new ResponseEntity(id, HttpStatus.OK);
    }

    @PostMapping(path = "/sections")
    public ResponseEntity createSection(@RequestBody Section section) {
        sectionService.saveOrUpdateSection(section);
        return new ResponseEntity(section, HttpStatus.OK);
    }

    @PutMapping(path = "/sections/{id}")
    public ResponseEntity updateSection(@PathVariable int id, @RequestBody Section section) {
        Section oldSection = sectionService.getSection(id);
        oldSection = section;
        sectionService.saveOrUpdateSection(oldSection);
        if (null == oldSection) {
            return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(oldSection, HttpStatus.OK);
    }
}