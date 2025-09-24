package com.joel_lucas_thibault.overlook_hotel.repository;

import com.joel_lucas_thibault.overlook_hotel.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByMail(String mail);
}
