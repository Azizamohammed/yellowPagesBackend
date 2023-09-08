package com.example.YellowPages.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Company {
    @Id
    private int compId;
    private String compName;
    private String compAddress;
    private String website;
    private String phoneNumber;
    private String email;

    @ManyToMany
    @JoinTable(name = "company_product",
               joinColumns = @JoinColumn(name = "compId"),
               inverseJoinColumns = @JoinColumn(name = "proId"))
    private Set<Product> products = new HashSet<>();
    
     @ManyToOne
    @JoinColumn(name = "feedbackId")
    private Review review;
}
