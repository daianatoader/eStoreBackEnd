package com.nttdata.estore.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "brand")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "brand_name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "photo_path")
    private String photoPath;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "brand")
    private Set<Product> products = new HashSet<Product>();

    public Brand() {
    }

    public Brand(String name, String description) {
        this.name = name;
        this.description = description;
        this.products = new HashSet<Product>(0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products.addAll(products);
    }
}
