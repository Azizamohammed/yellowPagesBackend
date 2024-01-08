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
    public String fullName;
    public String location;
    public String email;
    public int phone;
    // public int rates;


    

}
