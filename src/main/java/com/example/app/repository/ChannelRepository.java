package com.example.app.repository;

import com.example.app.entity.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ChannelRepository extends JpaRepository<Channel, Long> {
    Optional<Channel> findByName(String name);

    @Query(value = "SELECT channel FROM Channel channel WHERE channel.name LIKE %:filterValue%")
    List<Channel> findByFilterValue(@Param("filterValue") String filterValue);
}
