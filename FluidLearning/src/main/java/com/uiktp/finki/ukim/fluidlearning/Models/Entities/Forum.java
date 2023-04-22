package com.uiktp.finki.ukim.fluidlearning.Models.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "Forum", schema = "dbo")
@Getter
@Setter
public class Forum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;


    public Forum() {
    }

    public Forum(String title, String description) {
        this.title = title;
        this.description = description;
    }

}
