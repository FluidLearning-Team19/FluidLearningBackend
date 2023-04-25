package com.uiktp.finki.ukim.fluidlearning.Models.dto;

import lombok.Data;

@Data
public class LectureDto {

    private Integer ordinalNumber;

    private String title;

    private String description;

    private String contentMaterials;

    private CourseDto course;
}
