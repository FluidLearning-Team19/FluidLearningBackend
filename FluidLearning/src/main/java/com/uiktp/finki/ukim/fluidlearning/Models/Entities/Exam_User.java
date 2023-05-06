package com.uiktp.finki.ukim.fluidlearning.Models.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "Examuser", schema = "dbo")
@Getter
@Setter
public class Exam_User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="examid", nullable=false)
    private Exam exam;

    @ManyToOne
    @JoinColumn(name="userid", nullable=false)
    private Users user;

    @Column(name = "totalscore")
    private Integer totalScore;

    @Column(name = "datecompleted")
    private LocalDateTime dateCompleted;

    public Exam_User() {
    }

    public Exam_User(Exam exam, Users user, Integer totalScore, LocalDateTime dateCompleted) {
        this.exam = exam;
        this.user = user;
        this.totalScore = totalScore;
        this.dateCompleted = dateCompleted;
    }

    public Exam_User(Exam exam, Users user, Integer totalScore){
        this.exam = exam;
        this.user = user;
        this.totalScore = totalScore;
        this.dateCompleted = LocalDateTime.now();
    }
}
