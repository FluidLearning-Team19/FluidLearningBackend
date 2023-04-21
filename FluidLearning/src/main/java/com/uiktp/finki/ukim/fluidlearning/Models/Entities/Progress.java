package com.uiktp.finki.ukim.fluidlearning.Models.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Progress", schema = "dbo")
@Getter
@Setter
public class Progress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(
            name = "percentage",
            columnDefinition = "DECIMAL(18,2)"
    )
    private Double percentage;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name="courseUserId", nullable=false)
    private Course_User course_user;

}
