package com.uiktp.finki.ukim.fluidlearning.Models.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Table(name = "Forumquestion", schema = "dbo")
@Getter
@Setter
public class ForumQuestion {
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
    @JoinColumn(name="forumid", nullable=false)
    private Forum forum;

    public ForumQuestion() {
    }

    public ForumQuestion(String content, LocalDateTime datePosted, int likes, Users user, Forum forum) {
        this.content = content;
        this.datePosted = datePosted;
        this.likes = likes;
        this.user = user;
        this.forum = forum;
    }

}
