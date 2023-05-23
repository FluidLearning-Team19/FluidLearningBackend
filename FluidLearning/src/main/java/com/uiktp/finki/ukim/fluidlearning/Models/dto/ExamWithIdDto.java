package com.uiktp.finki.ukim.fluidlearning.Models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamWithIdDto {
    private String id;
    private String code;
    private String title;
    private String description;
    private Integer totalTime;
    private Integer totalPoints;
    private Integer numberOfQuestions;
    private CourseDto courseDto;
}
