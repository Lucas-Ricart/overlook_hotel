package com.joel_lucas_thibault.overlook_hotel.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // ✅ nouvelle syntaxe pour Spring Security 6+
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/login-client", "/login-employee", "/css/**", "/images/**").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form.disable()) // on désactive le login par défaut
            .csrf(csrf -> csrf.disable());    // à activer plus tard si nécessaire

        return http.build();
    }
}
