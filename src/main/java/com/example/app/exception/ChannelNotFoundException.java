package com.example.app.exception;

public class ChannelNotFoundException extends RuntimeException {

    public ChannelNotFoundException(String message) {
        super(message);
    }
}
