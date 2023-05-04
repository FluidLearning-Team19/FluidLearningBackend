package com.uiktp.finki.ukim.fluidlearning.Models.dto;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Exam;
import lombok.Data;

@Data
public class ExamQuestionDto {

    private String content;
    private Integer points;
    private Exam exam;

    public ExamQuestionDto(String content, Integer points, Exam exam) {
        this.content = content;
        this.points = points;
        this.exam = exam;
    }
}
