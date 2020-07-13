package com.example.app.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "like")
@Data
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date_created")
    private Date dateCreated;

    @ManyToOne
    @JoinColumn(name = "like_status_id")
    private LikeStatus likeStatus;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}