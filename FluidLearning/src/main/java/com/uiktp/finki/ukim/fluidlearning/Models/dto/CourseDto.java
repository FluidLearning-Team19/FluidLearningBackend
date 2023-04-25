package com.uiktp.finki.ukim.fluidlearning.Models.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDto {
    private String code;
    private String title;
    private String description;
    private int numberOfLectures;
    private String categoryName;

    public CourseDto(String code, String title, String description, int numberOfLectures, String categoryName) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.numberOfLectures = numberOfLectures;
        this.categoryName = categoryName;
    }

    public CourseDto() {
    }
}
