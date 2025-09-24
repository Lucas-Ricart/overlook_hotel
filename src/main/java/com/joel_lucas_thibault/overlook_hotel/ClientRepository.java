package com.joel_lucas_thibault.overlook_hotel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}

//findAll : List<Client> findAll() (recupérer tous les clients);
//findById : Optional<Client> findById(Long id) (recupérer un client par son id);
//save : Client save(Client client) (ajouter ou mettre à jour un client);
//deleteById : void deleteById(Long id) (supprimer un client par son id);