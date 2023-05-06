package com.uiktp.finki.ukim.fluidlearning.Models.Entities;

import com.uiktp.finki.ukim.fluidlearning.Models.dto.ExamDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static java.util.Objects.isNull;

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

    public Exam(ExamDto examDto){
        this.code = examDto.getCode();
        this.title = examDto.getTitle();
        this.description = examDto.getDescription();
        this.totalTime = examDto.getTotalTime();
        this.totalPoints = examDto.getTotalPoints();
        this.numberOfQuestions = examDto.getNumberOfQuestions();
        this.course = examDto.getCourse();
    }

    public void modifyExam(ExamDto examDto){
        this.code = isNull(examDto.getCode()) ? this.code : examDto.getCode();
        this.title = isNull(examDto.getTitle()) ? this.title : examDto.getTitle();
        this.description = isNull(examDto.getDescription()) ? this.description : examDto.getDescription();
        this.totalTime = isNull(examDto.getTotalTime()) ? this.totalTime : examDto.getTotalTime();
        this.totalPoints = isNull(examDto.getTotalPoints()) ? this.totalPoints : examDto.getTotalPoints();
        this.numberOfQuestions = isNull(examDto.getNumberOfQuestions()) ? this.numberOfQuestions : examDto.getNumberOfQuestions();
        this.course = isNull(examDto.getCourse()) ? this.course : examDto.getCourse();
    }
}
