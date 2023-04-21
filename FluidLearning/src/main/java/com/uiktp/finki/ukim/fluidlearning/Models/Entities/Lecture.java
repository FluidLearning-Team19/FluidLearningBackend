package com.uiktp.finki.ukim.fluidlearning.Models.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Lecture", schema = "dbo")
@Getter
@Setter
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ordinalnumber")
    private Integer ordinalNumber;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "contentmaterials")
    private String contentMaterials;

    @ManyToOne
    @JoinColumn(name="courseid", nullable=false)
    private Course course;

    public Lecture() {
    }

    public Lecture(Integer ordinalNumber, String title, String description, String contentMaterials, Course course) {
        this.ordinalNumber = ordinalNumber;
        this.title = title;
        this.description = description;
        this.contentMaterials = contentMaterials;
        this.course = course;
    }
}
