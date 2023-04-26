package com.uiktp.finki.ukim.fluidlearning.Service.impl;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Review;
import com.uiktp.finki.ukim.fluidlearning.Models.Exceptions.ReviewNotFoundException;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.ReviewDto;
import com.uiktp.finki.ukim.fluidlearning.Repository.ReviewRepository;
import com.uiktp.finki.ukim.fluidlearning.Service.ReviewService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Optional<Review> findById(Integer id) {
        return this.reviewRepository.findById(id);
    }

    @Override
    public List<Review> findAll() {
        return this.reviewRepository.findAll();
    }

    @Override
    public Optional<Review> save(String comment, Double rating, LocalDateTime datePosted) {
        Review review = new Review();
        review.setComment(comment);
        review.setRating(rating);
        review.setDatePosted(datePosted);
        return Optional.of(this.reviewRepository.save(review));
    }

    @Override
    public Optional<Review> save(ReviewDto reviewDto) {
        Review review = new Review();
        review.setComment(reviewDto.getComment());
        review.setRating(reviewDto.getRating());
        review.setDatePosted(reviewDto.getDatePosted());
        return Optional.of(this.reviewRepository.save(review));
    }

    @Override
    public Optional<Review> edit(Integer id, String comment, Double rating, LocalDateTime datePosted) {
        Review review = this.reviewRepository.findById(id).orElseThrow(() -> new ReviewNotFoundException(id));
        review.setComment(comment);
        review.setRating(rating);
        review.setDatePosted(datePosted);
        return Optional.of(this.reviewRepository.save(review));
    }

    @Override
    public Optional<Review> edit(Integer id, ReviewDto reviewDto) {
        Review review = this.reviewRepository.findById(id).orElseThrow(() -> new ReviewNotFoundException(id));
        review.setComment(reviewDto.getComment());
        review.setRating(reviewDto.getRating());
        review.setDatePosted(reviewDto.getDatePosted());
        return Optional.of(this.reviewRepository.save(review));
    }

    @Override
    public void deleteById(Integer id) {
        this.reviewRepository.deleteById(id);
    }
}
