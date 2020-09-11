package com.example.app.validator.channel.name;

import com.example.app.exception.ChannelNotFoundException;
import com.example.app.service.ChannelService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ChannelNameNotTakenValidator implements ConstraintValidator<ChannelNameNotTaken, String> {

    private final ChannelService channelService;

    public ChannelNameNotTakenValidator(ChannelService channelService) {
        this.channelService = channelService;
    }

    @Override
    public void initialize(ChannelNameNotTaken constraintAnnotation) {
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        try {
            channelService.findByName(name);
            return false;
        } catch (ChannelNotFoundException e) {
            return true;
        }
    }
}
