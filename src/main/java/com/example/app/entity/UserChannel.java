package com.example.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_channel")
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

}
