package com.example.app.repository;

import com.example.app.entity.LikeStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeStatusRepository extends JpaRepository<LikeStatus,Long> {
    Optional<LikeStatus> findByName(String name);
}
