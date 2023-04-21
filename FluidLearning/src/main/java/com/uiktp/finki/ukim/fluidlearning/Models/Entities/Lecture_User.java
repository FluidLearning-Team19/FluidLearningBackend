package com.uiktp.finki.ukim.fluidlearning.Models.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "Lectureuser", schema = "dbo")
@Getter
@Setter
public class Lecture_User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="lectureid", nullable=false)
    private Lecture lecture;

    @ManyToOne
    @JoinColumn(name="userid", nullable=false)
    private Users user;

    @Column(name = "datecompleted")
    private LocalDateTime dateCompleted;

    public Lecture_User() {
    }

    public Lecture_User(Lecture lecture, Users user, LocalDateTime dateCompleted) {
        this.lecture = lecture;
        this.user = user;
        this.dateCompleted = dateCompleted;
    }
}
