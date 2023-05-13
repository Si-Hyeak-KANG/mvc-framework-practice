package org.example.di_framework.controller;

import org.example.di_framework.annotation.Controller;
import org.example.di_framework.annotation.Inject;
import org.example.di_framework.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    @Inject
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }
}
