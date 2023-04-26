package com.uiktp.finki.ukim.fluidlearning.Models.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ForumQuestionNotFoundException extends RuntimeException {
    public ForumQuestionNotFoundException(int id) {
        super(String.format("Could not find a forum question with this id: %d", id));
    }
}
