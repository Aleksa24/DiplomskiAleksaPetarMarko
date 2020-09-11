package com.example.app.exception.channel;

public class ChannelNotFoundException extends RuntimeException {
    public ChannelNotFoundException(String message) {
        super(message);
    }
}
