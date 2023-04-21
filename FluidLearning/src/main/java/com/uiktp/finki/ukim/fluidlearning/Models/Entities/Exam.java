package com.uiktp.finki.ukim.fluidlearning.Models.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Exam", schema = "dbo")
@Getter
@Setter
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "code")
    private String code;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "totaltime")
    private Integer totalTime;

    @Column(name = "totalpoints")
    private Integer totalPoints;

    @Column(name = "numberofquestions")
    private Integer numberOfQuestions;

    @ManyToOne
    @JoinColumn(name="courseid", nullable=false)
    private Course course;

    public Exam() {
    }

    public Exam(String code, String title, String description, Integer totalTime, Integer totalPoints, Integer numberOfQuestions, Course course) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.totalTime = totalTime;
        this.totalPoints = totalPoints;
        this.numberOfQuestions = numberOfQuestions;
        this.course = course;
    }
}
