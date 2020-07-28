package com.example.app.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "post")
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "body")
    private String body;

    @Column(name = "date_created")
    private Date dateCreated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "channel_id")
    private Channel channel;

//    @OneToMany
//    @JoinColumn(name = "post_id")
//    private List<Like> likes;
//
//    @OneToMany
//    @JoinColumn(name = "post_id")
//    private List<Comment> comments;
//
//    @OneToMany
//    @JoinColumn(name = "post_id")
//    private List<Attachment> attachments;

}
