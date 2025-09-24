package com.joel_lucas_thibault.overlook_hotel.controller;

import com.joel_lucas_thibault.overlook_hotel.entity.Client;
import com.joel_lucas_thibault.overlook_hotel.repository.ClientRepository;
import com.joel_lucas_thibault.overlook_hotel.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.Valid;

@Controller
public class AuthController {
    @Autowired private ClientRepository clientRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @GetMapping("/login")
    public String login(@RequestParam(value = "type", defaultValue = "client") String type, Model model) {
        model.addAttribute("type", type); // "client" ou "manager" pour pages distinctes
        return "login"; // Template Thymeleaf unique, mais conditionnel
    }

    @PostMapping("/login")
    public String loginPost() {
        return "redirect:/dashboard";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("client", new Client());
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute Client client, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
        }
        if (clientRepository.findByMail(client.getMail()).isPresent()) {
            model.addAttribute("error", "Email déjà utilisé");
            return "register";
        }
        client.setMotdepasse(encoder.encode(client.getMotdepasse()));
        clientRepository.save(client);
        return "redirect:/login?type=client&registered";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getPrincipal() instanceof CustomUserDetails) {
            CustomUserDetails user = (CustomUserDetails) auth.getPrincipal();
            model.addAttribute("userType", user.getUserType());
            if ("CLIENT".equals(user.getUserType())) {
                return "redirect:/client/reservations";
            } else {
                return "redirect:/manager/rooms";
            }
        }
        return "redirect:/login";
    }
}