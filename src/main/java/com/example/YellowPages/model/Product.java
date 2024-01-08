package com.example.YellowPages.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Product {
    @Id
    private Long proId;
    private String productName;
    // Other product attributes

    @ManyToMany(mappedBy = "products")
    private Set<Company> companies = new HashSet<>();

    // Other fields, getters, setters
}
