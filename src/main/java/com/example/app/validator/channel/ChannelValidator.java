package com.example.app.validator.channel;

import com.example.app.dto.channel.ChannelDto;
import com.example.app.exception.ChannelNotFoundException;
import com.example.app.service.ChannelService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ChannelValidator implements ConstraintValidator<Channel, ChannelDto> {

    private final ChannelService channelService;

    public ChannelValidator(ChannelService channelService) {
        this.channelService = channelService;
    }

    @Override
    public void initialize(Channel constraintAnnotation) {
    }

    @Override
    public boolean isValid(ChannelDto channelDto, ConstraintValidatorContext constraintValidatorContext) {
        try {
            channelService.findByName(channelDto.getName());
            return channelDto.getId().equals(channelService.findByName(channelDto.getName()).getId());
        } catch (ChannelNotFoundException e) {
            return true;
        }
    }
}
