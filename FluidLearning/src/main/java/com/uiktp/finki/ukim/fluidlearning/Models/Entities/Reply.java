package com.uiktp.finki.ukim.fluidlearning.Models.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "Replies", schema = "dbo")
@Getter
@Setter
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "content")
    private String content;

    @Column(name = "dateposted")
    private LocalDateTime datePosted;

    @Column(name = "likes")
    private int likes;

    @ManyToOne
    @JoinColumn(name="userid", nullable=false)
    private Users user;

    @ManyToOne
    @JoinColumn(name="forumquestionid", nullable=false)
    private ForumQuestion forumQuestion;

    public Reply() {
    }

    public Reply(String content, LocalDateTime datePosted, int likes, Users user, ForumQuestion forumQuestion) {
        this.content = content;
        this.datePosted = datePosted;
        this.likes = likes;
        this.user = user;
        this.forumQuestion = forumQuestion;
    }
}
