package com.example.YellowPages.controllerAPI;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.YellowPages.model.Product;
import com.example.YellowPages.model.Review;
import com.example.YellowPages.service.ReviewService;

@RestController
@RequestMapping("/Review")
public class ReviewAPI {

    public final ReviewService reviewService;

    public ReviewAPI(ReviewService reviewService){
        this.reviewService = reviewService;
    }

     @GetMapping("/all")
    public ResponseEntity<?> getReview(){
        try{
            List<Review> reviews  = reviewService.getAll();
            return new ResponseEntity<>(reviews, HttpStatus.OK);
        }
        catch(Exception exception){
            return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
        }    
    }


     @GetMapping("ById{feedbackId}")

    public ResponseEntity<?> getByID(@PathVariable int feedbackId){
        try{
            Optional<Review> optionalReview  = reviewService.getById(feedbackId);
            return new ResponseEntity<>(optionalReview,HttpStatus.OK);
        }catch(Exception exception){
            return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
        }
    }


     @DeleteMapping("/delete/{feedbackId}")
    public ResponseEntity<?> delete(@PathVariable Integer feedbackId){
        try{
            reviewService.deleteById(0);
            return new ResponseEntity<>("deleted",HttpStatus.OK);

        }catch(Exception exception){
            return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
        }
    }



    @PostMapping("/add")
    public ResponseEntity<?> addProduct (@RequestBody Review review){
        try{
            
            Review review2 = reviewService.addReview(review);
            return new ResponseEntity<>("inserted",HttpStatus.OK);

    }catch(Exception exception){
        return new ResponseEntity<>("not inserted",HttpStatus.BAD_REQUEST);

    }
}




    


    







    


    
}
