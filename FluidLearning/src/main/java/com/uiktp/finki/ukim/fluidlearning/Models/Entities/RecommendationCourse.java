package com.uiktp.finki.ukim.fluidlearning.Models.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "recommendationcourse", schema = "dbo")
@Getter
@Setter
public class RecommendationCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="courseid", nullable=false)
    private Course course;

    @ManyToOne
    @JoinColumn(name="courserecommendedid", nullable=false)
    private Course recommendedCourse;

    public RecommendationCourse(Course course, Course recommendedCourse) {
        this.course = course;
        this.recommendedCourse = recommendedCourse;
    }

    public RecommendationCourse() {
    }
}
