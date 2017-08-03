package com.nttdata.estore.services;

import com.nttdata.estore.entities.Brand;
import com.nttdata.estore.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public Iterable<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

}
