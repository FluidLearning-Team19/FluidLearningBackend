package com.uiktp.finki.ukim.fluidlearning.Models.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReviewDto {

    private String comment;
    private Double rating;
    private LocalDateTime datePosted;

    public ReviewDto() {
    }

    public ReviewDto(String comment, Double rating, LocalDateTime datePosted) {
        this.comment = comment;
        this.rating = rating;
        this.datePosted = datePosted;
    }


}
