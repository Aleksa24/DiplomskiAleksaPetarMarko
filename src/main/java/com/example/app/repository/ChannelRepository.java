package com.example.app.repository;

import com.example.app.entity.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChannelRepository extends JpaRepository<Channel, Long> {
    Optional<Channel> findByName(String name);
}
