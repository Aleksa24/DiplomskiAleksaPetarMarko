package com.example.app.service;

import com.example.app.dto.channel.CategoryDto;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> findAll();
}
