package com.joel_lucas_thibault.overlook_hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index"; // correspond à templates/index.html
    }

    @GetMapping("/login-client")
    public String loginClient() {
        return "login-client"; // correspond à templates/login-client.html
    }

    @GetMapping("/login-employee")
    public String loginEmployee() {
        return "login-employee"; // correspond à templates/login-employee.html
    }
}
