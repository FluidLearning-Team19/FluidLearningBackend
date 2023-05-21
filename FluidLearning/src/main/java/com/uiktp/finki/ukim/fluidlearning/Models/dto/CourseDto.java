package com.uiktp.finki.ukim.fluidlearning.Models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {

    private int id;
    private String code;

    private String title;

    private String description;

    private int numberOfLectures;

    private CategoryDto category;

    public CourseDto(String code, String title, String description, int numberOfLectures, String categoryName, String categoryDescription) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.numberOfLectures = numberOfLectures;
        this.category = new CategoryDto(categoryName, categoryDescription);
    }
}
