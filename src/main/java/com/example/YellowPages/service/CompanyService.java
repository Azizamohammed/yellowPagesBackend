package com.example.YellowPages.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.YellowPages.model.Company;
import com.example.YellowPages.repository.CompanyRepo;
@Service
public class CompanyService {


    public final CompanyRepo companyRepo;
     public CompanyService(CompanyRepo companyRepo){
        this.companyRepo = companyRepo;
     }

     //all
     public List<Company> getAll(){
        return companyRepo.findAll( );
     }


     //ById
     public Optional<Company> getById(int compId){
        return companyRepo.findById(compId);
     }
    

      //delete
      public void deleteById(int compId){
        companyRepo.deleteById(compId);
      }

     //add 
      public Company addCompany(Company company){
        return companyRepo.save(company);
      }

      public List<Company> findAll() {
         return null;
      }

    public void save(Company updatedCompany) {
    }

   
    

     }
