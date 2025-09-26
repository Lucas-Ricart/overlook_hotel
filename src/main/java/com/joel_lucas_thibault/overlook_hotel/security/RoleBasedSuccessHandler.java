package com.joel_lucas_thibault.overlook_hotel.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import java.io.IOException;

public class RoleBasedSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res,
                                        Authentication auth) throws IOException, ServletException {
        String role = auth.getAuthorities().iterator().next().getAuthority();

        // Vérifier le rôle exact avec le préfixe ROLE_
        if ("ROLE_employee".equals(role)) {
            res.sendRedirect("/employee/home");
        } else if ("ROLE_manager".equals(role)) {
            res.sendRedirect("/manager/home");
        } else if ("ROLE_client".equals(role)) {
            res.sendRedirect("/client/home");
        } else {
            res.sendRedirect("/"); // fallback
        }
    }
}
