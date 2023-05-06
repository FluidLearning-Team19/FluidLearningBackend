package com.uiktp.finki.ukim.fluidlearning.Models.dto;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamDto {

    private String code;
    private String title;
    private String description;
    private Integer totalTime;
    private Integer totalPoints;
    private Integer numberOfQuestions;
    private Course course;
}
