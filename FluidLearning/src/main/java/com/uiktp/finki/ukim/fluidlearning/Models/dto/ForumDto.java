package com.uiktp.finki.ukim.fluidlearning.Models.dto;

import lombok.Data;

@Data
public class ForumDto {

    private String title;
    private String description;

    public ForumDto() {

    }

    public ForumDto(String title, String description) {
        this.title = title;
        this.description = description;
    }

}
