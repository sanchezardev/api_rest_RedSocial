package com.example.api_rest_RedSocial.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // 1. Deshabilitamos CSRF (Cross-Site Request Forgery)
            .csrf(csrf -> csrf.disable())

            // 2. Configuramos qué rutas son públicas y cuáles privadas
            .authorizeHttpRequests(auth -> auth
                    // Dejamos públicas las rutas de Swagger (que veo que tienes en tu pom.xml)
                    .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
                    // Dejamos pública una posible ruta para registrarse o iniciar sesión (ajusta si tienes otra)
                    // .requestMatchers("/api/auth/**").permitAll()
                    .requestMatchers("/api/registro", "/api/login").permitAll()
                    // Cualquier otra petición a la API requerirá estar autenticado
                    .anyRequest().authenticated()
            )
                // --- NUEVO 3: Le decimos a Spring que NO use sesiones (Cookies) porque usaremos Tokens (STATELESS) ---
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                // --- NUEVO 4: Ponemos a nuestro guardia (JWT) en la puerta principal ANTES del filtro por defecto ---
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
