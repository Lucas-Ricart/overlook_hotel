package com.joel_lucas_thibault.overlook_hotel.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
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
                .requestMatchers("/", "/client/login", "/employee/login", "/register", "/css/**", "/js/**").permitAll()
                .requestMatchers("/client/**").hasRole("client")
                .requestMatchers("/employee/**").hasAnyRole("employee", "manager")
                .requestMatchers("/manager/**").hasRole("manager")
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/client/login") // page par défaut si on tape /login
                .loginProcessingUrl("/perform-login") // commun aux 2
                .successHandler(new RoleBasedSuccessHandler())
                .failureUrl("/client/login?error=true") // si mauvais mot de passe
                .permitAll()
            )
            .formLogin(form -> form
                .loginPage("/employee/login")
                .loginProcessingUrl("/perform-login")  // même URL que ci-dessus
                .successHandler(new RoleBasedSuccessHandler())
                .failureUrl("/employee/login?error=true")
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
    public PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }

    @Bean
    public AuthenticationManager authManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
