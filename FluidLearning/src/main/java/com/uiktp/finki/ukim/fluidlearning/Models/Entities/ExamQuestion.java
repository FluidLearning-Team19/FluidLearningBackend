package com.uiktp.finki.ukim.fluidlearning.Models.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Examquestion", schema = "dbo")
@Getter
@Setter
public class ExamQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "content")
    private String content;

    @Column(name = "points")
    private Integer points;

    @ManyToOne
    @JoinColumn(name="examid", nullable=false)
    private Exam exam;

    public ExamQuestion() {
    }

    public ExamQuestion(String content, Integer points, Exam exam) {
        this.content = content;
        this.points = points;
        this.exam = exam;
    }

    public ExamQuestion(String content, Integer points) {
        this.content = content;
        this.points = points;
    }
}
