package com.uiktp.finki.ukim.fluidlearning.Models.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ForumNotFoundException extends RuntimeException {
    public ForumNotFoundException(int id) {
        super(String.format("Could not find a forum with this id: %d", id));
    }
}
