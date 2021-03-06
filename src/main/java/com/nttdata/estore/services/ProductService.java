package com.nttdata.estore.services;

import com.nttdata.estore.entities.Product;
import com.nttdata.estore.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    public Product getProduct(int id) {
        return productRepository.findOne(id);
    }

    public void deleteProduct(int id) {
        productRepository.delete(id);
    }

    public void saveOrUpdateProduct(Product product) {
        productRepository.save(product);
    }
}
