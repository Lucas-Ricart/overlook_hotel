package com.joel_lucas_thibault.overlook_hotel;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChambreController {

    private final ChambreService chambreService;

    public ChambreController(ChambreService chambreService) {
        this.chambreService = chambreService;
    }

    @GetMapping("/chambres")
    public String afficherChambres(
            @RequestParam(name = "disponible", required = false) Boolean disponible,
            Model model) {

        List<Chambre> chambres;
        if (Boolean.TRUE.equals(disponible)) {
            chambres = chambreService.getChambresDisponibles();
        } else {
            chambres = chambreService.getAllChambres();
        }

        model.addAttribute("chambres", chambres);
        model.addAttribute("filtreDisponible", Boolean.TRUE.equals(disponible));
        return "chambres";
    }
}
