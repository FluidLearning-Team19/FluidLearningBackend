package com.uiktp.finki.ukim.fluidlearning.Models.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDtoRequest {
    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private LocalDateTime dateOfBirth;
}
