package com.nttdata.estore.controllers;

import com.nttdata.estore.entities.Product;
import com.nttdata.estore.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(path = "/products")
    public @ResponseBody
    Iterable<Product> getAllProducts() { return productService.findAll(); }

    @GetMapping(path = "/products/{id}")
    public ResponseEntity getProduct(@PathVariable("id") int id){
        Product product = productService.getById(id);
        if (product == null) {
            return new ResponseEntity("No Product found for id " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(product, HttpStatus.OK);
    }

    @DeleteMapping(path= "/products/{id}")
    public ResponseEntity deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
        return new ResponseEntity(id,HttpStatus.OK);
    }

    @PostMapping(path = "/products")
    public ResponseEntity createSection(@RequestBody Product product) {
        productService.createProduct(product);
        return new ResponseEntity(product, HttpStatus.OK);
    }

    @PutMapping(path = "/products/{id}")
    public ResponseEntity updateProduct(@PathVariable int id, @RequestBody Product product) {
        Product oldProduct = productService.getById(id);
        oldProduct = product;
        productService.createProduct(oldProduct);
        if (null == oldProduct) {
            return new ResponseEntity("No Product found for ID " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(oldProduct, HttpStatus.OK);
    }
}
