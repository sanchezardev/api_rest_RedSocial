package com.example.api_rest_RedSocial.controller;

import com.example.api_rest_RedSocial.domain.model.Usuario;
import com.example.api_rest_RedSocial.domain.repository.UsuarioRepository;
import com.example.api_rest_RedSocial.dto.LoginRequest;
import com.example.api_rest_RedSocial.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.security.core.AuthenticationException;
import java.util.Collections;

@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //Nuevas herramientas inyectadas
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/registro")
    public ResponseEntity<?> registrarUsuario(@RequestBody Usuario newUser){

        //1. Comprobamos si el nombre ya existe para no tener duplicados
        if (usuarioRepository.findByNombre(newUser.getNombre()).isPresent()){
            return ResponseEntity.badRequest().body("El nombre ya existe");
        }

        //2. Codificamos la contraseña en texto plano antes de guardarla
        String contrasenaCifrada = passwordEncoder.encode(newUser.getContrasena());
        newUser.setContrasena(contrasenaCifrada);

        //3. Guardamos el usuario
        Usuario savedUser = usuarioRepository.save(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getNombre(), loginRequest.getContrasena())
            );
        }catch (AuthenticationException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectos");
        }

        String tokenGenerado = jwtUtil.generarToken(loginRequest.getNombre());

        return ResponseEntity.ok(Collections.singletonMap("token",tokenGenerado));
    }
}