package com.uiktp.finki.ukim.fluidlearning.Models.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Examanswer", schema = "dbo")
@Getter
@Setter
public class ExamAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "content")
    private String content;

    @Column(name = "isrightanswer")
    private Integer isRightAnswer;

    @ManyToOne
    @JoinColumn(name="examquestionid", nullable=false)
    private ExamQuestion examQuestion;

    public ExamAnswer() {
    }

    public ExamAnswer(String content, Integer isRightAnswer, ExamQuestion examQuestion) {
        this.content = content;
        this.isRightAnswer = isRightAnswer;
        this.examQuestion = examQuestion;
    }
}
