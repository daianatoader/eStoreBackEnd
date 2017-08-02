package com.nttdata.estore.controllers;
import com.nttdata.estore.entities.Brand;
import com.nttdata.estore.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/brand")
public class BrandController {

    @Autowired
    private BrandRepository brandRepository;

    @GetMapping(path="/allBrands")
    public @ResponseBody Iterable<Brand> getAllBrands() {
        // This returns a JSON or XML with the users
        return brandRepository.findAll();
    }
}
