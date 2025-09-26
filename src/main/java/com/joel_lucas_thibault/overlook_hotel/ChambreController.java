package com.joel_lucas_thibault.overlook_hotel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ChambreController {

    private final ChambreService chambreService;

    public ChambreController(ChambreService chambreService) {
        this.chambreService = chambreService;
    }

    // Afficher toutes les chambres ou seulement les disponibles
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

    // B. Frontend (gestionnaire) : Vue d'ensemble des réservations
    @GetMapping("/reservations/gestionnaire")
    public String afficherReservationsGestionnaire(Model model) {
        List<Chambre> reservations = chambreService.getReservations();
        model.addAttribute("reservations", reservations);
        return "reservations_gestionnaire";
    }

    // C. Frontend (client) : Vue des réservations d’un client
    @GetMapping("/reservations/client/{idClient}")
    public String afficherReservationsClient(@PathVariable Long idClient, Model model) {
        List<Chambre> reservations = chambreService.getReservationsClient(idClient);
        model.addAttribute("reservations", reservations);
        model.addAttribute("idClient", idClient);
        return "reservations_client";
    }
}