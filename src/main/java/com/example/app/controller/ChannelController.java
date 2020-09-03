package com.example.app.controller;

import com.example.app.dto.channel.ChannelDto;
import com.example.app.dto.channel.ChannelShortDto;
import com.example.app.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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
        return channelService.save(channelDto);
    }

    @GetMapping("/findAllByUserId")
    public List<ChannelShortDto> findAllByUserId(@RequestParam("id") Long id){
        return  channelService.findAllByUserId(id);
    }

    @GetMapping("{id}/profile-picture")
    public ResponseEntity<Resource> findProfilePictureById(@PathVariable Long id) throws IOException {

        ByteArrayResource resource = channelService.findProfilePictureById(id);

        return ResponseEntity.ok()
                .contentLength(resource.contentLength())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
}
