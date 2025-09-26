package com.joel_lucas_thibault.overlook_hotel;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ChambreService chambreService;

    public ReservationController(ChambreService chambreService) {
        this.chambreService = chambreService;
    }

    // A. Backend (API) : Créer une réservation
    @PostMapping("/creer/{idChambre}/{idClient}")
    public ResponseEntity<Chambre> creerReservation(@PathVariable Long idChambre, @PathVariable Long idClient) {
        Optional<Chambre> chambre = chambreService.creerReservation(idChambre, idClient);
        return chambre.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.badRequest().build());
    }

    // A. Backend (API) : Annuler une réservation
    @PostMapping("/annuler/{idChambre}")
    public ResponseEntity<Chambre> annulerReservation(@PathVariable Long idChambre) {
        Optional<Chambre> chambre = chambreService.annulerReservation(idChambre);
        return chambre.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }

    // A. Backend (API) : Consulter toutes les réservations (gestionnaire)
    @GetMapping("/gestionnaire")
    public ResponseEntity<List<Chambre>> getReservationsGestionnaire() {
        List<Chambre> reservations = chambreService.getReservations();
        return ResponseEntity.ok(reservations);
    }

    // A. Backend (API) : Consulter les réservations d’un client
    @GetMapping("/client/{idClient}")
    public ResponseEntity<List<Chambre>> getReservationsClient(@PathVariable Long idClient) {
        List<Chambre> reservations = chambreService.getReservationsClient(idClient);
        return ResponseEntity.ok(reservations);
    }
}