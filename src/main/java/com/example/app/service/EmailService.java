package com.example.app.service;

import com.example.app.dto.user.UserDto;

import javax.mail.MessagingException;
import java.security.NoSuchAlgorithmException;

public interface EmailService {
    void sendPasswordToUserEmail(String email, String password);

    void sendAccountActivationLinkToUserEmail(UserDto savedUserDto) throws NoSuchAlgorithmException, MessagingException;
}
