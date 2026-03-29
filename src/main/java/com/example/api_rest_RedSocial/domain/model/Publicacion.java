package com.example.api_rest_RedSocial.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Publicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El titulo no puede estar vacio")
    @Size(min = 3, max = 100, message = "El titulo debe tener entre 3 y 50 caracteres")
    private String titulo;

    @NotBlank(message = "El contenido no puede estar vacio")
    @Size(max = 2000, message = "El contenido debe tener menos de 2000 caracteres")
    private String contenido;

    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "publicacion")
    private List<Comentario> comentarios;

}
