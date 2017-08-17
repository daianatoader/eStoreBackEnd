package com.nttdata.estore.controllers;

import com.nttdata.estore.entities.Product;
import com.nttdata.estore.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;

import static com.nttdata.estore.controllers.UpdateController.photoPath;

@RestController
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @Value("${frontend.resources.folder}")
    private String resourcesLocation;

    @GetMapping(path = "/products")
    public @ResponseBody
    Iterable<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping(path = "/products/{id}")
    public ResponseEntity getProduct(@PathVariable("id") int id) {
        Product product = productService.getProduct(id);
        if (product == null) {
            return new ResponseEntity("No Product found for id " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(product, HttpStatus.OK);
    }

    @DeleteMapping(path = "/products/{id}")
    public ResponseEntity deleteProduct(@PathVariable int id) {
        if (null == getProduct(id)) {
            return new ResponseEntity("No Product found", HttpStatus.NOT_FOUND);
        }
        deleteFileFromDisk(productService.getProduct(id).getPhotoPath());
        productService.deleteProduct(id);
        return new ResponseEntity(id, HttpStatus.OK);
    }

    @PostMapping(path = "/products")
    public ResponseEntity createSection(@RequestBody Product product) {
        productService.saveOrUpdateProduct(product);
        return new ResponseEntity(product, HttpStatus.OK);
    }

    @PutMapping(path = "/products/{id}")
    public ResponseEntity updateProduct(@PathVariable int id, @RequestBody Product product) {
        // TODO check method
        Product oldProduct = productService.getProduct(id);
        if (oldProduct.getPhotoPath() != null) {
            deleteFileFromDisk(oldProduct.getPhotoPath());
        }
        product.setPhotoPath(photoPath);
        oldProduct = product;
        productService.saveOrUpdateProduct(oldProduct);
        if (null == oldProduct) {
            return new ResponseEntity("No Product found for ID " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(oldProduct, HttpStatus.OK);
    }

    private void deleteFileFromDisk(String filePath) {
        File file = new File(resourcesLocation + filePath);
        if (file.exists())
            file.delete();
    }
}
