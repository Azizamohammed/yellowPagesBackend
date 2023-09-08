package com.example.YellowPages.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class Review {
    @Id
    public int feedbackId; 
    public String comment;
    public int rates;


    

}
