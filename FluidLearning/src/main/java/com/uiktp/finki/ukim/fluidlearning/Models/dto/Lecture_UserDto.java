package com.uiktp.finki.ukim.fluidlearning.Models.dto;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Lecture;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Lecture_UserDto {

    private Lecture lecture;

    private UsersDto user;

    private LocalDateTime dateCompleted;
}
