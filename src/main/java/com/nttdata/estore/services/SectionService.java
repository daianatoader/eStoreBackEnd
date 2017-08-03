package com.nttdata.estore.services;

import com.nttdata.estore.entities.Section;
import com.nttdata.estore.repositories.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SectionService {

    @Autowired
    private SectionRepository sectionRepository;

    public Iterable<Section> findAll() {
        return sectionRepository.findAll();
    }
}
