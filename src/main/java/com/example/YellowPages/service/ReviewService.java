package com.example.YellowPages.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.YellowPages.model.Review;
import com.example.YellowPages.repository.ReviewRepo;
@Service
public class ReviewService {
    public final ReviewRepo reviewRepo;
    public ReviewService(ReviewRepo reviewRepo){
        this.reviewRepo = reviewRepo;
    }

    //all
    public List<Review> getAll(){
        return reviewRepo.findAll();
    }

    //ById
    public Optional<Review> getById(int feedbackId){
        return  reviewRepo.findById(feedbackId);
    }

    //delete


public void  deleteById(int feedbackId){
    reviewRepo.deleteById(feedbackId);
}

//add
public Review addReview(Review review){
    return reviewRepo.save(review);
}

public void save(Review updatReview) {
}


}