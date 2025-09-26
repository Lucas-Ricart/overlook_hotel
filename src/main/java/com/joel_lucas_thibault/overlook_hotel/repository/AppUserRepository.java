package com.joel_lucas_thibault.overlook_hotel.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.joel_lucas_thibault.overlook_hotel.model.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
    Optional<AppUser> findByMail(String mail);
    boolean existsByMail(String mail);
}
