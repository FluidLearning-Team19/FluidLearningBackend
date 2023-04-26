package com.uiktp.finki.ukim.fluidlearning.Service;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Review;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.ReviewDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReviewService {
    Optional<Review> findById(Integer id);

    List<Review> findAll();

    Optional<Review> save(String comment, Double rating, LocalDateTime datePosted);

    Optional<Review> save(ReviewDto reviewDto);

    Optional<Review> edit(Integer id, String comment, Double rating, LocalDateTime datePosted);

    Optional<Review> edit(Integer id, ReviewDto reviewDto);

    void deleteById(Integer id);
}
