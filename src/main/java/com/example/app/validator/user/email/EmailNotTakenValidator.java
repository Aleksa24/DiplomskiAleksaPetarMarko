package com.example.app.validator.user.email;

import com.example.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailNotTakenValidator implements ConstraintValidator<EmailNotTaken, String> {

    private final UserService userService;

    @Autowired
    public EmailNotTakenValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(EmailNotTaken constraintAnnotation) {
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return userService.findByEmail(email).isPresent();
    }
}
