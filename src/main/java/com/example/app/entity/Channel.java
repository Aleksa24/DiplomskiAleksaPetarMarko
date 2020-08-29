package com.example.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "channel")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Channel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "date_created")
    @CreatedDate
    private Date dateCreated;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "channel_status_id")
    private ChannelStatus channelStatus;

    @ManyToOne
    @JoinColumn(name = "communication_direction_id")
    private CommunicationDirection communicationDirection;

    @OneToMany
    @JoinColumn(name = "channel_id")
    private List<Channel> channels;

    @OneToMany
    @JoinColumn(name = "channel_id")
    private List<Attachment> attachments;

    @OneToMany
    @JoinColumn(name = "channel_id")
    private List<UserChannel> userChannels;

    @OneToMany
    @JoinColumn(name = "channel_id")
    private List<Post> posts;

}
