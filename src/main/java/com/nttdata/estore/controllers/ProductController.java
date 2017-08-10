package com.nttdata.estore.controllers;

import com.nttdata.estore.entities.Product;
import com.nttdata.estore.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(path = "/allProducts")
    public @ResponseBody
    Iterable<Product> getAllProducts() {
        return productService.findAll();
    }
}
