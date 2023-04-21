package com.uiktp.finki.ukim.fluidlearning.Models.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "Favouritecourse", schema = "dbo")
@Getter
@Setter
public class FavouriteCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="courseid", nullable=false)
    private Course course;

    @ManyToOne
    @JoinColumn(name="userid", nullable=false)
    private Users user;

    @Column(name = "datesaved")
    private LocalDateTime dateSaved;

    public FavouriteCourse() {
    }

    public FavouriteCourse(Course course, Users user, LocalDateTime dateSaved) {
        this.course = course;
        this.user = user;
        this.dateSaved = dateSaved;
    }
}
