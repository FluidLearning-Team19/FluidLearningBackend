package com.uiktp.finki.ukim.fluidlearning.Models.dto;


import com.uiktp.finki.ukim.fluidlearning.Models.Entities.ForumQuestion;
import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplyDto {

    private String content;
    private LocalDateTime datePosted;
    private int likes;
    private Users user;
    private ForumQuestion forumQuestion;

    public ReplyDto(String content, LocalDateTime datePosted, int likes) {
        this.content = content;
        this.datePosted = datePosted;
        this.likes = likes;
    }
}
