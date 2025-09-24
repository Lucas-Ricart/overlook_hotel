package com.joel_lucas_thibault.overlook_hotel.security;

import com.joel_lucas_thibault.overlook_hotel.entity.Client;
import com.joel_lucas_thibault.overlook_hotel.entity.Employer;
import com.joel_lucas_thibault.overlook_hotel.repository.ClientRepository;
import com.joel_lucas_thibault.overlook_hotel.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired private ClientRepository clientRepository;
    @Autowired private EmployerRepository employerRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        // Cherche d'abord dans clients
        return clientRepository.findByMail(mail)
                .map(client -> createUserDetails(client, "CLIENT"))
                .orElseGet(() -> {
                    // Puis dans employers
                    Employer employer = employerRepository.findByMail(mail)
                            .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé: " + mail));
                    return createUserDetails(employer, "MANAGER");
                });
    }

    private CustomUserDetails createUserDetails(Object user, String userType) {
        String role = userType.equals("CLIENT") ? "ROLE_CLIENT" : "ROLE_MANAGER";
        return new CustomUserDetails(
                ((user instanceof Client ? ((Client) user).getMail() : ((Employer) user).getMail()),
                (user instanceof Client ? ((Client) user).getMotdepasse() : ((Employer) user).getMotdepasse()),
                Collections.singleton(new SimpleGrantedAuthority(role)),
                (user instanceof Client ? ((Client) user).getId() : ((Employer) user).getId()),
                userType
        );
    }
}