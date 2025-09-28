package com.joel_lucas_thibault.overlook_hotel;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private final UsersRepository userRepository;

    public UsersService(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> getAllClients() {
        return userRepository.findByRole("client");
    }

    public Users getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<Users> getUserByLastName(String lastName) {
        return userRepository.findByLastName(lastName);
    }

    public Users saveUser(Users user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
