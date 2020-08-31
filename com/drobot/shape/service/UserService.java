package com.drobot.shape.service;

import com.drobot.shape.validator.UserValidator;

public class UserService {

    private static final String ADMIN_LOGIN = "admin";
    private static final String ADMIN_PASSWORD = "admin";

    public boolean userExists(String login, String password) {
        UserValidator validator = new UserValidator();
        boolean result = (validator.areLoginPasswordValid(login, password)
                && login.equals(ADMIN_LOGIN) && password.equals(ADMIN_PASSWORD));
        return result;
    }
}
