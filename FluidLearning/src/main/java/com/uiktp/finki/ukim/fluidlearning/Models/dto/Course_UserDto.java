package com.uiktp.finki.ukim.fluidlearning.Models.dto;

import lombok.Data;

@Data
public class Course_UserDto {

    private CourseDto course;

    private UsersDto user;

    private Integer numberOfCompletedLectures;
}
