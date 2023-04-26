package com.uiktp.finki.ukim.fluidlearning.Models.dto;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Course_User;
import lombok.Data;

@Data
public class ProgressDto {

    private Double percentage;

    private String status;

    private Course_User course_user;
}
