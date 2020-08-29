package com.example.app.service;

import com.example.app.dto.channel.CommunicationDirectionDto;

import java.util.List;

public interface CommunicationDirectionService {
    List<CommunicationDirectionDto> findAll();
}
