package com.example.app.repository;

import com.example.app.entity.UserChannel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserChannelRepository extends JpaRepository<UserChannel, Long> {

    List<UserChannel> findAllByUserId(Long userId);
}
