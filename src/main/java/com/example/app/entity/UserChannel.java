package com.example.app.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_channel")
public class UserChannel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date_joined")
    private Date dateJoined;

    @ManyToOne
    @JoinColumn(name = "channel_role_id")
    private ChannelRole channelRole;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
