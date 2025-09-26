package com.joel_lucas_thibault.overlook_hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/client/login")
    public String loginClient() { return "/client/login"; }

    @GetMapping("/employee/login")
    public String loginEmployee() { return "/employee/login"; }
}
