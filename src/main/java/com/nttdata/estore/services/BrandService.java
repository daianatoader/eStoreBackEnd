package com.nttdata.estore.services;

import com.nttdata.estore.entities.Brand;
import com.nttdata.estore.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public Iterable<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    public Brand getBrand(int id) {
        return brandRepository.findOne(id);
    }

    public void addBrand(Brand brand) {
        brandRepository.save(brand);
    }

    public void delete(int id) {
        brandRepository.delete(id);
    }

}
