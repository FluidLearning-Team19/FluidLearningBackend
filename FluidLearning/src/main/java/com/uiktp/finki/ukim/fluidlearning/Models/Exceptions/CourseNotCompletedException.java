package com.uiktp.finki.ukim.fluidlearning.Models.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class CourseNotCompletedException extends RuntimeException{
    public CourseNotCompletedException() {
        super("User has not completed the course yet.");
    }
}