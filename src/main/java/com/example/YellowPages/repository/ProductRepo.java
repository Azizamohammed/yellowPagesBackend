package com.example.YellowPages.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.YellowPages.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    
   //  @Query("SELECT * FROM Product  WHERE productName = :productName")
     List<Product> findByProductName(String productName);
}
