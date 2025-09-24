package com.joel_lucas_thibault.overlook_hotel.repository;

import com.joel_lucas_thibault.overlook_hotel.entity.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Integer> {
    Optional<Employer> findByMail(String mail);
}