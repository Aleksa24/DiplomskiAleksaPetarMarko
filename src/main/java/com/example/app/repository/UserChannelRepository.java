package com.example.app.repository;

import com.example.app.entity.UserChannel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserChannelRepository extends JpaRepository<UserChannel, Long> {

    List<UserChannel> findAllByUserId(Long userId);

    @Query("SELECT userChannel FROM UserChannel userChannel WHERE userChannel.channel.id = ?1 and userChannel.user.id <> ?2")
    Page<UserChannel> findAllByUserInChannel(Long channelId, Long loggedUserId, Pageable pageable);

    @Query("SELECT userChannel FROM UserChannel userChannel WHERE userChannel.channel.id <> ?1 and userChannel.user.id <> ?2 group by userChannel.user")
    Page<UserChannel> findAllByUserNotChannel(Long channelId, Long loggedUserId, Pageable pageable);

    @Query("SELECT userChannel FROM UserChannel userChannel WHERE userChannel.user.id = :userId AND userChannel.channel.id = :channelId")
    UserChannel findByUserIdAndChannelId(@Param("userId") Long userId,@Param("channelId") Long channelId);
}