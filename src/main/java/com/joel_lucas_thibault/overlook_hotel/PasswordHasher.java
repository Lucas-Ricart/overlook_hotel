package com.joel_lucas_thibault.overlook_hotel;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHasher {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println("Mot de passe client : " + encoder.encode("12345"));
        System.out.println("Mot de passe employé : " + encoder.encode("azerty"));
        System.out.println("Mot de passe employé : " + encoder.encode("qwerty"));
    }
}
