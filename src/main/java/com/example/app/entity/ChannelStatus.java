package com.example.app.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "channel_status")
@Data
public class ChannelStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
}
