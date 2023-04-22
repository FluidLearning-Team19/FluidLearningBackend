package com.uiktp.finki.ukim.fluidlearning.Models.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "Course", schema = "dbo")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "code")
    private String code;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "numberoflectures")
    private int numberOfLectures;

    @ManyToOne
    @JoinColumn(name="categoryid", nullable=false)
    private Category category;


    public Course() {
    }

    public Course(String code, String title, String description, int numberOfLectures, Category category) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.numberOfLectures = numberOfLectures;
        this.category =  category;
    }

}
