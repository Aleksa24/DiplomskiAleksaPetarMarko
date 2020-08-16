package com.example.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "text")
    private String text;

    @Column(name = "date_created")
    @CreatedDate
    private Date dateCreated;

    @Column(name = "date_last_modified")
    @LastModifiedDate
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
