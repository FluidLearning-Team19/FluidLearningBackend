package com.uiktp.finki.ukim.fluidlearning.Models.dto;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.ExamQuestion;
import lombok.Data;

@Data
public class ExamAnswerDto {
    private String content;
    private Integer isRightAnswer;
    private ExamQuestion examQuestion;

    public ExamAnswerDto(String content, Integer isRightAnswer, ExamQuestion examQuestion) {
        this.content = content;
        this.isRightAnswer = isRightAnswer;
        this.examQuestion = examQuestion;
    }
}
