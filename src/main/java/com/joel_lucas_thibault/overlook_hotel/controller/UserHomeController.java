package com.joel_lucas_thibault.overlook_hotel.controller;

import com.joel_lucas_thibault.overlook_hotel.security.CustomUserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserHomeController {

    @GetMapping("/client/home")
    public String clientHome(@AuthenticationPrincipal CustomUserDetails user, Model model) {
        model.addAttribute("name", user.getFirstName() + " " + user.getLastName());
        return "client/home";
    }

    @GetMapping("/employee/home")
    public String employeeHome(@AuthenticationPrincipal CustomUserDetails user, Model model) {
        model.addAttribute("name", user.getFirstName() + " " + user.getLastName());
        return "employee/home";
    }

    @GetMapping("/manager/home")
    public String managerHome(@AuthenticationPrincipal CustomUserDetails user, Model model) {
        model.addAttribute("name", user.getFirstName() + " " + user.getLastName());
        return "manager/home";
    }
}
