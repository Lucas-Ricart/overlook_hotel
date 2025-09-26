package com.joel_lucas_thibault.overlook_hotel.controller;

import com.joel_lucas_thibault.overlook_hotel.model.AppUser;
import com.joel_lucas_thibault.overlook_hotel.repository.AppUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    private final AppUserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public RegisterController(AppUserRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new AppUser());
        return "register";
    }

    @PostMapping("/register")
    public String processRegister(@ModelAttribute("user") AppUser user, Model model) {

        // 🔒 Normalize mail
        String email = user.getMail().trim().toLowerCase();
        user.setMail(email);

        // ✅ Check uniqueness
        if (userRepo.existsByMail(email)) {
            model.addAttribute("error", "This email is already used.");
            return "register";
        }

        // ✅ Encode password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // ✅ Force role CLIENT
        user.setRole("client");

        userRepo.save(user);

        model.addAttribute("success", "Registration successful! You can now login.");
        return "register";
    }
}
