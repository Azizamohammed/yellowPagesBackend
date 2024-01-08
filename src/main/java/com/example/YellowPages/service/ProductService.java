package com.example.YellowPages.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.YellowPages.model.Product;
import com.example.YellowPages.repository.ProductRepo;

@Service
public class ProductService {

    public final  ProductRepo productRepo;

    public ProductService(ProductRepo productRepo){
        this.productRepo = productRepo;
    }
    //all
     public List<Product> getAll(){
        return productRepo.findAll( );
     }

      //ById
      public  Optional<Product> getById(int proId){
        return productRepo.findById((long) proId);
      }


      // by name
       public List<Product> getProductByName( String productName ){
        return productRepo.findByProductName(productName);
       }

    //delete
    public void deleteById( int proId){
        productRepo.deleteById((long) proId);

    }

    //add
    public Product addProduct(Product product){
        return productRepo.save(product);
    }
    public Product save(Product originalProduct) {
        return null;
    }
    public Product updateProduct(int proId, Product product) {
        return null;
    }
   
}
