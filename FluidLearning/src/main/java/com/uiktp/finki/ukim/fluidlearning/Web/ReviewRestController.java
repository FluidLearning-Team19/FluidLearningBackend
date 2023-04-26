package com.uiktp.finki.ukim.fluidlearning.Web;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Review;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.ReviewDto;
import com.uiktp.finki.ukim.fluidlearning.Service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/review")
@CrossOrigin(value = "*")
public class ReviewRestController {

    private final ReviewService reviewService;

    public ReviewRestController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<Review> findAll() {
        return this.reviewService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> findById(@PathVariable Integer id) {
        return this.reviewService.findById(id)
                .map(reply -> ResponseEntity.ok().body(reply))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Review> save(@RequestBody ReviewDto reviewDto) {
        return this.reviewService.save(reviewDto)
                .map(reply -> ResponseEntity.ok().body(reply))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Review> edit(@PathVariable Integer id, @RequestBody ReviewDto reviewDto) {
        return this.reviewService.edit(id, reviewDto)
                .map(reply -> ResponseEntity.ok().body(reply))
                .orElseGet(() -> ResponseEntity.badRequest().build());

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        this.reviewService.deleteById(id);
        if (this.reviewService.findById(id).isEmpty()) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
