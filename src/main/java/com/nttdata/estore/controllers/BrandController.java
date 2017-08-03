package com.nttdata.estore.controllers;
import com.nttdata.estore.entities.Brand;
import com.nttdata.estore.repositories.BrandRepository;
import com.nttdata.estore.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path="/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping(path = "/allBrands")
    public @ResponseBody Iterable<Brand> getAllBrands() {
        return brandService.getAllBrands();
    }
}
