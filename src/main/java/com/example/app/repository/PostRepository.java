package com.example.app.repository;

import com.example.app.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    @Query(value = "SELECT post FROM Post post WHERE post.title LIKE %:filterValue%")
    List<Post> findByFilterValue(@Param("filterValue") String filterValue);
}
