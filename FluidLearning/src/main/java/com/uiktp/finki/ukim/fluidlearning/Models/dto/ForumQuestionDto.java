package com.uiktp.finki.ukim.fluidlearning.Models.dto;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Forum;
import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Users;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ForumQuestionDto {

    private String content;
    private LocalDateTime datePosted;
    private int likes;
    private Users user;
    private Forum forum;

    public ForumQuestionDto(){

    }

    public ForumQuestionDto(String content, LocalDateTime datePosted, int likes, Users user, Forum forum) {
        this.content = content;
        this.datePosted = datePosted;
        this.likes = likes;
        this.user = user;
        this.forum = forum;
    }


}
