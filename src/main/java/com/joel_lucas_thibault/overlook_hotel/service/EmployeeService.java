package com.joel_lucas_thibault.overlook_hotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.joel_lucas_thibault.overlook_hotel.model.Users;
import com.joel_lucas_thibault.overlook_hotel.repository.UsersRepository;

@Service
public class EmployeeService {

    private final UsersRepository userRepository;

    public EmployeeService(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> getAllEmployees() {
        return userRepository.findByRole("employee");
    }

    public Users getEmployeeById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<Users> getEmployeeByName(String name) {
        return userRepository.findByLastName(name);
    }

    public Users saveEmployee(Users employee) {
        return userRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        userRepository.deleteById(id);
    }

}
