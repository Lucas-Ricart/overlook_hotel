package com.joel_lucas_thibault.overlook_hotel.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/login-client", "/login-employee", "/register", "/css/**", "/js/**").permitAll()
                .requestMatchers("/client/**").hasRole("CLIENT")
                .requestMatchers("/employee/**").hasRole("EMPLOYEE")
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                // ✅ On accepte deux pages mais un seul traitement
                .loginPage("/login-client") // Spring en utilise une par défaut, mais on gère la redirection
                .loginProcessingUrl("/perform-login") // action unique
                .successForwardUrl("/post-login")      // redirection après succès
                .failureUrl("/login-client?error=true") // si erreur, renvoi par défaut
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .permitAll()
            );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
