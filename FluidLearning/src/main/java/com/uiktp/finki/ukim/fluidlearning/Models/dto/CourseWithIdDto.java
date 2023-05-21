package com.uiktp.finki.ukim.fluidlearning.Models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseWithIdDto {
    private String id;

    private String code;

    private String title;

    private String description;

    private int numberOfLectures;

    private CategoryDto category;
}
