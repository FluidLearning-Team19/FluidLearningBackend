package com.uiktp.finki.ukim.fluidlearning.Models.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ReviewNotFoundException extends RuntimeException {
    public ReviewNotFoundException(int id) {
        super(String.format("Could not find a review with this id: %d", id));
    }
}
