package com.uiktp.finki.ukim.fluidlearning.Models.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class UsersDto {

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private String role;

    private LocalDateTime dateOfBirth;

    private LocalDateTime dateCreated;
}
