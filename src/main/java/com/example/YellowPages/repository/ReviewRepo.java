package com.example.YellowPages.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.YellowPages.model.Review;
@Repository
public interface ReviewRepo  extends JpaRepository<Review, Integer>{

    
}