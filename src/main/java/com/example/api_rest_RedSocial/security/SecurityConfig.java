package com.example.api_rest_RedSocial.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

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
                    .requestMatchers("/api/registro").permitAll()
                    // Cualquier otra petición a la API requerirá estar autenticado
                    .anyRequest().authenticated()
            )
                .httpBasic(org.springframework.security.config.Customizer.withDefaults());
        
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
