package com.example.app.mapper;

import com.example.app.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AttachmentRepository extends JpaRepository<Attachment,Long> {

    Optional<Attachment> findByUrl(String url);

}
