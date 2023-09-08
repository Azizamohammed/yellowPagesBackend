package com.example.YellowPages.controllerAPI;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.YellowPages.model.Company;
import com.example.YellowPages.model.Product;
import com.example.YellowPages.model.Review;
import com.example.YellowPages.service.CompanyService;
@RestController
@RequestMapping("/Company")
public class CompanyAPI {

    public final CompanyService companyService;


    public CompanyAPI(CompanyService companyService){
        this.companyService = companyService;
    }


     @GetMapping("/all")
    public ResponseEntity<?> getReview(){
        try{
            List<Company> companies  = companyService.getAll();
            return new ResponseEntity<>(companies, HttpStatus.OK);
        }
        catch(Exception exception){
            return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
        }    
    }


      @GetMapping("ById{compId}")

    public ResponseEntity<?> getByID(@PathVariable int compId){
        try{
        
            Optional<Company>optionalReview  = companyService.getById(compId);
            return new ResponseEntity<>(optionalReview,HttpStatus.OK);
        }catch(Exception exception){
            return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
        }
    }


     @DeleteMapping("/delete{compId}")
    public ResponseEntity<?> delete(@PathVariable Integer compId){
        try{
            companyService.deleteById(compId);
            return new ResponseEntity<>("delete",HttpStatus.OK);

        }catch(Exception exception){
            return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/add")
    public ResponseEntity<?> addProduct (@RequestBody Company company){
        try{
            
            //Review review2 = reviewService.addReview(review);
            Company company2 = companyService.addCompany(company);
            return new ResponseEntity<>("inserted",HttpStatus.OK);

    }catch(Exception exception){
        return new ResponseEntity<>("not inserted",HttpStatus.BAD_REQUEST);

    }
}



@PutMapping("/editById{compId}")
public  ResponseEntity<?> editCompany(@PathVariable int compId, @RequestBody Company company){
    try{
        Optional<Company> existingCompany = companyService.getById(compId);
        if(existingCompany.isPresent()){
            Company updatedCompany = existingCompany.get();
            companyService.save(updatedCompany);
            return new ResponseEntity<>(updatedCompany,HttpStatus.OK);
        }else{
            return new ResponseEntity<>("product are not found",HttpStatus.OK);
        }
    }catch(Exception exception){
        return new ResponseEntity<>("error",HttpStatus.BAD_REQUEST);
    }
}




    




    
}
