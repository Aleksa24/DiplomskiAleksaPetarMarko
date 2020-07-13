package com.example.app.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "like_status")
@Data
public class LikeStatus {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
}
