package com.uiktp.finki.ukim.fluidlearning.Models.dto;

import lombok.Data;

@Data
public class CourseDto {

    private String code;

    private String title;

    private String description;

    private int numberOfLectures;

    private CategoryDto category;
}
