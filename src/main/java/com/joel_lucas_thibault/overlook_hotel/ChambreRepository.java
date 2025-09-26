package com.joel_lucas_thibault.overlook_hotel;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.domain.Sort;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    List<Chambre> findByDisponible(Boolean disponible, Sort sort);

    // Récupère toutes les chambres réservées (id_client_reservation n'est pas NULL)
    List<Chambre> findById_client_reservationIsNotNull(Sort sort);

    // Récupère les chambres réservées par un client spécifique
    List<Chambre> findById_client_reservation(Long idClient, Sort sort);
}