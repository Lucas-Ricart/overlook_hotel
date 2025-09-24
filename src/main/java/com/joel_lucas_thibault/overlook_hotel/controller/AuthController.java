package com.joel_lucas_thibault.overlook_hotel.controller;

import com.joel_lucas_thibault.overlook_hotel.entity.Client;
import com.joel_lucas_thibault.overlook_hotel.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class AuthController {
	private final ClientRepository clientRepository;
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public AuthController(ClientRepository clientRepository, PasswordEncoder passwordEncoder) {
		this.clientRepository = clientRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("client", new Client());
		return "register";
	}

	@PostMapping("/register")
	public String register(@ModelAttribute Client client, Model model) {
		if (clientRepository.findByMail(client.getMail()).isPresent()) {
			model.addAttribute("error", "Email déjà utilisé");
			return "register";
		}
		client.setPassword(passwordEncoder.encode(client.getPassword()));
		clientRepository.save(client);
		return "redirect:/login?registerSuccess";
	}
}
