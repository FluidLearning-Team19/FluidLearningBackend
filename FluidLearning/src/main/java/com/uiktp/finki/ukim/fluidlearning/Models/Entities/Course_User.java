package com.uiktp.finki.ukim.fluidlearning.Models.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Courseuser", schema = "dbo")
@Getter
@Setter
public class Course_User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="courseid", nullable=false)
    private Course course;

    @ManyToOne
    @JoinColumn(name="userid", nullable=false)
    private Users user;

    @Column(name = "numberofcompletedlectures")
    private Integer numberOfCompletedLectures;
}
