package com.example.app.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "comment_status")
@Data
public class CommentStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
}
