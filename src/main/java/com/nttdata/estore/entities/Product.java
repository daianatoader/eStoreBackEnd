package com.nttdata.estore.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "details")
    private String details;

    @Column(name = "price")
    private float price;

    @Column(name = "photo_path")
    private String photoPath;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, targetEntity = Section.class)
    @JoinColumn(name = "section_id", nullable = false)
    private Section section;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, targetEntity = Brand.class)
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "products")
    private Set<Campaign> campaigns;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "products")
    private Set<Order> orders;

    public Product() {
    }

    public Product(String name, String details, float price, Section section, Brand brand) {
        this.name = name;
        this.details = details;
        this.price = price;
        this.section = section;
        this.brand = brand;
        this.campaigns = new HashSet<Campaign>(0);
        this.orders = new HashSet<Order>(0);
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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public Set<Campaign> getCampaigns() {
        return this.campaigns;
    }

    public void setCampaigns(Campaign campaign) {
        this.campaigns.add(campaign);
    }

    public Set<Order> getOrders() {
        return this.orders;
    }

    public void setOrders(Order order) {
        this.orders.add(order);
    }
}
