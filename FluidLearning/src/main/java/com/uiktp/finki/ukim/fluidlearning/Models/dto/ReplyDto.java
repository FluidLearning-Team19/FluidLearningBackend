package com.uiktp.finki.ukim.fluidlearning.Models.dto;


import com.uiktp.finki.ukim.fluidlearning.Models.Entities.ForumQuestion;
import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Users;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReplyDto {

    private String content;
    private LocalDateTime datePosted;
    private int likes;
    private Users user;
    private ForumQuestion forumQuestion;

    public ReplyDto() {

    }

    public ReplyDto(String content, LocalDateTime datePosted, int likes, Users user, ForumQuestion forumQuestion) {
        this.content = content;
        this.datePosted = datePosted;
        this.likes = likes;
        this.user = user;
        this.forumQuestion = forumQuestion;
    }
}
