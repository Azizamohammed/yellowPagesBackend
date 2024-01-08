package com.example.YellowPages.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.YellowPages.model.Company;


@Repository
public interface CompanyRepo  extends JpaRepository<Company,Integer> {
      
}
