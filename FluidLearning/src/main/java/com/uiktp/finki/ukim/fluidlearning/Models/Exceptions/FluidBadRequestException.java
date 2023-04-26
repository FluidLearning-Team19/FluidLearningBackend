package com.uiktp.finki.ukim.fluidlearning.Models.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class FluidBadRequestException extends RuntimeException  {
    public FluidBadRequestException(String message) {
        super(message);
    }
}
