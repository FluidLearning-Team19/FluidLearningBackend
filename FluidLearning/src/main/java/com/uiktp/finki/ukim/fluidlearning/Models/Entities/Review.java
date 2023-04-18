package com.uiktp.finki.ukim.fluidlearning.Models.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "Review", schema = "dbo")
@Getter
@Setter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "comment")
    private String comment;

    @Column(
            name = "rating",
            columnDefinition = "DECIMAL(18,2)"
    )
    private Double rating;

    @Column(name = "dateposted")
    private LocalDateTime datePosted;

    public Review(String comment, Double rating, LocalDateTime datePosted) {
        this.comment = comment;
        this.rating = rating;
        this.datePosted = datePosted;
    }

    public Review() {
    }
}
