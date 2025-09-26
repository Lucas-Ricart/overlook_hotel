package com.joel_lucas_thibault.overlook_hotel;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChambreService {

    private final ChambreRepository chambreRepository;

    public ChambreService(ChambreRepository chambreRepository) {
        this.chambreRepository = chambreRepository;
    }

    public List<Chambre> getAllChambres() {
        return chambreRepository.findAll(Sort.by("numero"));
    }

    public List<Chambre> getChambresDisponibles() {
        return chambreRepository.findByDisponible(true, Sort.by("numero"));
    }

    // Créer une réservation
    public Optional<Chambre> creerReservation(Long idChambre, Long idClient) {
        Optional<Chambre> chambreOpt = chambreRepository.findById(idChambre);
        
        if (chambreOpt.isPresent() && chambreOpt.get().getDisponible()) {
            Chambre chambre = chambreOpt.get();
            chambre.setDisponible(false);
            chambre.setId_client_reservation(idClient);
            return Optional.of(chambreRepository.save(chambre));
        }
        return Optional.empty();
    }

    // Annuler une réservation
    public Optional<Chambre> annulerReservation(Long idChambre) {
        Optional<Chambre> chambreOpt = chambreRepository.findById(idChambre);

        if (chambreOpt.isPresent() && !chambreOpt.get().getDisponible()) {
            Chambre chambre = chambreOpt.get();
            chambre.setDisponible(true);
            chambre.setId_client_reservation(null);
            return Optional.of(chambreRepository.save(chambre));
        }
        return Optional.empty();
    }

    // Consulter toutes les réservations (pour le gestionnaire)
    public List<Chambre> getReservations() {
        return chambreRepository.findById_client_reservationIsNotNull(Sort.by("numero"));
    }

    // Consulter les réservations d’un client
    public List<Chambre> getReservationsClient(Long idClient) {
        return chambreRepository.findById_client_reservation(idClient, Sort.by("numero"));
    }
}