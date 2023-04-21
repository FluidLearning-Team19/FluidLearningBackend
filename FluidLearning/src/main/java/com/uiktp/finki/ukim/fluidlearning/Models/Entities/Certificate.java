package com.uiktp.finki.ukim.fluidlearning.Models.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Certificate", schema = "dbo")
@Getter
@Setter
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "issharedonsocialmedia")
    private int isSharedOnSocialMedia;

    @ManyToOne
    @JoinColumn(name="examUserId", nullable=false)
    private Exam_User exam_user;

    public Certificate() {
    }

    public Certificate(String title, String description, int isSharedOnSocialMedia, Exam_User exam_user) {
        this.title = title;
        this.description = description;
        this.isSharedOnSocialMedia = isSharedOnSocialMedia;
        this.exam_user = exam_user;
    }
}
