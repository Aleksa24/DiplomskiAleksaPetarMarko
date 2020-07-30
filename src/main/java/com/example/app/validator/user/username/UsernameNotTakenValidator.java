package com.example.app.validator.user.username;

import com.example.app.exception.user.UserNotFoundException;
import com.example.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameNotTakenValidator implements ConstraintValidator<UsernameNotTaken, String> {

    private final UserService userService;

    @Autowired
    public UsernameNotTakenValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(UsernameNotTaken constraintAnnotation) {
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        try {
            userService.findByUsername(username);
            return true;
        } catch (UserNotFoundException e){
            return false;
        }
    }
}
