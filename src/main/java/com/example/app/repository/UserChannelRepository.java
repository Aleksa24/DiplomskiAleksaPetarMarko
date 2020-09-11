package com.example.app.repository;

import com.example.app.entity.UserChannel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserChannelRepository extends JpaRepository<UserChannel, Long> {

    List<UserChannel> findAllByUserId(Long userId);

    @Query("SELECT userChannel FROM UserChannel userChannel WHERE userChannel.channel.id = ?1 and userChannel.user.id <> ?2")
    Page<UserChannel> findAllByUserInChannel(Long channelId, Long loggedUserId, Pageable pageable);

    @Query("SELECT userChannel FROM UserChannel userChannel WHERE userChannel.channel.id <> ?1 and userChannel.user.id <> ?2")
    Page<UserChannel> findAllByUserNotChannel(Long channelId, Long loggedUserId, Pageable pageable);
}
