package com.joel_lucas_thibault.overlook_hotel.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.joel_lucas_thibault.overlook_hotel.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByMail(String mail);
}
