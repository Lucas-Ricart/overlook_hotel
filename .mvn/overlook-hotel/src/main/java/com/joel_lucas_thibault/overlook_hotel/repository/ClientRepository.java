package com.joel_lucas_thibault.overlook_hotel.repository;

import com.joel_lucas_thibault.overlook_hotel.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Optional<Client> findByMail(String mail);
}