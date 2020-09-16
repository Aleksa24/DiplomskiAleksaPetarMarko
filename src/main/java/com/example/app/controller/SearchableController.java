package com.example.app.controller;

import com.example.app.dto.Searchable;
import com.example.app.service.SearchableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/searchable")
public class SearchableController {

    private final SearchableService searchableService;

    @Autowired
    public SearchableController(SearchableService searchableService) {
        this.searchableService = searchableService;
    }

    @GetMapping("/channels-and-posts")
    public List<Searchable> getChannelsAndPosts(@RequestParam("filterValue") String filterValue,@RequestParam("userId")Long userId){
        return searchableService.getChannelsAndPosts(filterValue,userId);
    }
}
