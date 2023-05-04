package com.uiktp.finki.ukim.fluidlearning.Models.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ExamQuestionNotFound extends RuntimeException {
    public ExamQuestionNotFound(int id) {
        super(String.format("Could not find a ExamQuestion with this id: %d", id));
    }
}
