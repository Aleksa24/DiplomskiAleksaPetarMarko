package com.example.app.controller;

import com.example.app.dto.channel.ChannelDto;
import com.example.app.dto.channel.ChannelShortDto;
import com.example.app.dto.channel.UserChannelDto;
import com.example.app.entity.UserChannel;
import com.example.app.http.HttpResponse;
import com.example.app.service.ChannelService;
import com.example.app.util.ValidatorWrapper;
import com.example.app.validator.channel.groups.Edit;
import com.example.app.validator.channel.groups.Save;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/channel")
public class ChannelController {

    private final ChannelService channelService;

    @Autowired
    public ChannelController(ChannelService channelService) {
        this.channelService = channelService;
    }

    @GetMapping("/all")
    public List<ChannelShortDto> findAll() {
        return channelService.findAll();
    }

    @GetMapping("/{id}")
    public ChannelDto getById(@PathVariable("id") Long id) {
        return channelService.findById(id);
    }

    @PostMapping("/save")
    public ChannelDto save(@Validated(Save.class) @RequestBody ChannelDto channelDto) {
        return channelService.save(channelDto);
    }

    @PostMapping("/edit")
    public ChannelDto edit(@Validated(Edit.class) @RequestBody ChannelDto channelDto) {
        return channelService.save(channelDto);
    }

    @GetMapping("/findAllByUserId")
    public List<ChannelShortDto> findAllByUserId(@RequestParam("id") Long id) {
        return channelService.findAllByUserId(id);
    }

    @GetMapping("{id}/profile-picture")
    public ResponseEntity<Resource> findProfilePictureById(@PathVariable Long id) throws IOException {

        ByteArrayResource resource = channelService.findProfilePictureById(id);

        return ResponseEntity.ok()
                .contentLength(resource.contentLength())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

    @PostMapping("/upload-profile-image")
    public ResponseEntity<HttpResponse> uploadProfileImage(
            @RequestParam MultipartFile profileImage,
            @RequestParam Long id
    ) throws IOException {


        String resultMessage = channelService.uploadProfileImage(id, profileImage);

        return ResponseEntity
                .ok()
                .body(new HttpResponse(200, HttpStatus.OK, "PROFILE_IMAGE_CHANGED", resultMessage));
    }

    @GetMapping("find-by-name")
    public ChannelDto findByName(@RequestParam("name") String name) {
        return channelService.findByName(name);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class}) // TODO not working inside @RestControllerAdvice
    public ResponseEntity<Object> validationError(MethodArgumentNotValidException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());

        List<ValidatorWrapper> validatorWrappers = new ArrayList<>();
        ex.getBindingResult().getGlobalErrors()
                .forEach(objectError -> validatorWrappers.add(new ValidatorWrapper("global", objectError.getDefaultMessage())));

        ex.getBindingResult().getFieldErrors()
                .forEach(fieldError ->
                        validatorWrappers.add(new ValidatorWrapper(fieldError.getField(), fieldError.getDefaultMessage())));

        body.put("error", validatorWrappers);

        return new ResponseEntity<>(body, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/find-id-by-post-id")
    public Long findIdByPostId(@RequestParam("postId") Long postId) {
        return channelService.findIdByPostId(postId);
    }

    @GetMapping("/is-user-in-channel")
    public boolean isUserInChannel(@RequestParam("userId") Long userId, @RequestParam("channelId") Long channelId) {
        return channelService.isUserInChannel(userId, channelId);
    }

    @GetMapping("find-all-by-channel-and-user")
    public List<ChannelShortDto> findAllByChannelAndUser(
            @RequestParam("channelId") Long channelId,
            @RequestParam("userId") Long userId) {
        return channelService.findAllByChannelAndUser(channelId, userId);
    }

    @PostMapping("save-user-channel")
    public UserChannelDto saveUserChannel(@RequestBody UserChannel userChannel) {
        return channelService.saveUserChannel(userChannel);
    }

    @DeleteMapping("delete-user-channel")
    public UserChannelDto deleteUserChannel(@RequestParam Long userId,
                                            @RequestParam Long channelId) {
        return channelService.deleteUserChannel(userId, channelId);
    }
}
