package com.example.app.service;

import com.example.app.dto.Searchable;

import java.util.List;

public interface SearchableService {
    List<Searchable> getChannelsAndPosts(String filterValue,Long userId);
}
