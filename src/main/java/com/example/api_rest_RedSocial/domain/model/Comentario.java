package com.example.api_rest_RedSocial.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String campos;

    @ManyToOne
    @JoinColumn(name="usuario_id")
    @NotBlank(message = "El nombre no puede estar vacio")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="publicacion_id")
    private Publicacion publicacion;

}
