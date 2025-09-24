package com.joel_lucas_thibault.overlook_hotel;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.domain.Sort;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    List<Chambre> findByDisponible(Boolean disponible, Sort sort);
}

//findAll : List<Chambre> findAll() (recupérer toutes les chambres);
//findById : Optional<Chambre> findById(Long id) (recupérer une chambre par son id);
//save : Chambre save(Chambre chambre) (ajouter ou mettre à jour une chambre);
//deleteById : void deleteById(Long id) (supprimer une chambre par son id);
//findByDisponible : List<Chambre> findByDisponible(Boolean disponible) (recupérer les chambres disponibles ou non);
//findByNbPersonne : List<Chambre> findByNbPersonne(Integer nbPersonne) (recupérer les chambres en fonction du nombre de personnes qu'elles peuvent accueillir).