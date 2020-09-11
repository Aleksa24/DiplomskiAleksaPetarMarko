package com.example.app.service.impl;

import com.example.app.constant.EmailConstant;
import com.example.app.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {


    private final JavaMailSender emailSender;

    @Autowired
    public EmailServiceImpl(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }


    @Override
    public void sendPasswordToUserEmail(String email, String password) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("knowledge.helper112@gmail.com");
        message.setTo(email);
        message.setSubject(EmailConstant.EMAIL_SEND_PASSWORD_SUBJECT);
        message.setText(String.format(EmailConstant.EMAIL_SEND_PASSWORD_BODY_MESSAGE, password));
        emailSender.send(message);
    }

}
