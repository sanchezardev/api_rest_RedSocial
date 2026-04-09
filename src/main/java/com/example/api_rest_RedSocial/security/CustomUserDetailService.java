package com.example.api_rest_RedSocial.security;


import com.example.api_rest_RedSocial.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        // Buscamos al usuario y, si no existe, lanzamos la excepción directamente.
        // Si existe, lo devolvemos y dejamos que Spring Security se encargue de validar la contraseña.
        return usuarioRepository.findByNombre(name)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario not found in the DB: " + name));
    }
}
