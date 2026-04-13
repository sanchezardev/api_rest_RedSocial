package com.example.api_rest_RedSocial.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    private String nombre;
    private String contrasena;
}
