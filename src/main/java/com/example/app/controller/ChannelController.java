package com.example.app.controller;

import com.example.app.dto.channel.ChannelDto;
import com.example.app.dto.channel.ChannelShortDto;
import com.example.app.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/channel")
public class ChannelController {

    private final ChannelService channelService;

    @Autowired
    public ChannelController(ChannelService channelService) {
        this.channelService = channelService;
    }

    @GetMapping("/all")
    public List<ChannelShortDto> findAll(){
        return  channelService.findAll();
    }

    @GetMapping("/{id}")
    public ChannelDto getById(@PathVariable("id") Long id){
        return  channelService.findById(id);
    }

    @PostMapping("/save")
    public ChannelDto save(@RequestBody ChannelDto channelDto){
        System.out.println("channel/save:");
        return channelService.save(channelDto);
    }
}
