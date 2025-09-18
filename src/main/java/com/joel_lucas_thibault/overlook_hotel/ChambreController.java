package com.joel_lucas_thibault.overlook_hotel;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChambreController {

    private final ChambreService chambreService;

    public ChambreController(ChambreService chambreService) {
        this.chambreService = chambreService;
    }

    @GetMapping("/chambres")
    public String afficherChambres(Model model) {
        List<Chambre> chambres = chambreService.getAllChambres();
        model.addAttribute("chambres", chambres);
        return "chambres"; // Nom du fichier HTML dans templates/
    }
}
