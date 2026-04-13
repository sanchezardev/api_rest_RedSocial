package com.example.api_rest_RedSocial.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        final String authorizationHeader = request.getHeader("Authorization");

        // --- CHIVATOS DE DEPURACIÓN ---
        System.out.println("\n--- 🔍 NUEVA PETICIÓN INTERCEPTADA ---");
        System.out.println("Cabecera recibida: " + authorizationHeader);

        String username = null;
        String jwt = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
            System.out.println("Token limpio extraído: " + jwt);

            try {
                // Intentamos descifrarlo matemáticamente
                username = jwtUtil.extraerUsername(jwt);
                System.out.println("✅ El token es de: " + username);
            } catch (Exception e) {
                System.out.println("❌ ERROR MATEMÁTICO AL DESCIFRAR EL TOKEN: " + e.getMessage());
            }
        } else {
            System.out.println("⚠️ La petición no trae un Bearer Token correcto.");
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

            if (jwtUtil.validarToken(jwt, userDetails.getUsername())) {
                System.out.println("✅ TOKEN VÁLIDO. ¡Abriendo las puertas para " + username + "!");
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            } else {
                System.out.println("❌ EL TOKEN NO ES VÁLIDO (quizás caducó o no coincide el usuario)");
            }
        }

        chain.doFilter(request, response);
    }
}
