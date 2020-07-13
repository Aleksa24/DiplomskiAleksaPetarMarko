package com.example.app.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "comment")
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "text")
    private String text;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "date_last_modified")
    private Date dateLastModified;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "comment_status_id")
    private CommentStatus commentStatus;

    @OneToMany
    @JoinColumn(name = "comment_id")
    private List<Like> likes;

    @OneToMany
    @JoinColumn(name = "comment_id")
    private List<Attachment> attachments;

    @OneToMany
    @JoinColumn(name = "comment_id")
    private List<Comment> comments;


}