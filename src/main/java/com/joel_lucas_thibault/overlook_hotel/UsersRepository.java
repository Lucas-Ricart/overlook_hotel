package com.joel_lucas_thibault.overlook_hotel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
    List<Users> findByRole(String role);
    List<Users> findByLastName(String lastName);
}

//findAll : List<Users> findAll() (recupérer tous les utilisateurs);
//findById : Optional<Users> findById(Long id) (recupérer un utilisateur par son id);
//save : Users save(Users user) (ajouter ou mettre à jour un utilisateur);
//deleteById : void deleteById(Long id) (supprimer un client par son id);