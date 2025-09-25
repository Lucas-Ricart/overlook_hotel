package com.joel_lucas_thibault.overlook_hotel.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    // Pages de login
    @GetMapping("/login-client")
    public String loginClient() {
        return "login-client";
    }

    @GetMapping("/login-employee")
    public String loginEmployee() {
        return "login-employee";
    }

    // ✅ Après authentification réussie, Spring forward ici
    @PostMapping("/post-login")
    public String postLogin(Authentication auth) {
        boolean isClient = auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch(r -> r.equals("ROLE_CLIENT"));
        boolean isEmployee = auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch(r -> r.equals("ROLE_EMPLOYEE"));

        if (isClient) {
            return "redirect:/client/home";
        } else if (isEmployee) {
            return "redirect:/employee/home";
        }
        return "redirect:/"; // fallback
    }
}
