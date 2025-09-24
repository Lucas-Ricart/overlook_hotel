package com.joel_lucas_thibault.overlook_hotel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

//findAll : List<Employee> findAll() (recupérer tous les employés);
//findById : Optional<Employee> findById(Long id) (recupérer un employé par son id);
//save : Employee save(Employee employee) (ajouter ou mettre à jour un employé);
//deleteById : void deleteById(Long id) (supprimer un employé par son id);
//findByRole : List<Employee> findByRole(String role) (recupérer les employés par leur rôle).