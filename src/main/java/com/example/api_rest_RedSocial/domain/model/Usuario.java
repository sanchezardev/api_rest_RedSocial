package com.example.api_rest_RedSocial.domain.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@JsonSerialize
@Getter
@Setter
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El nombre no puede estar vacio")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    private String nombre;

    @NotBlank(message = "La contrasena no puede estar vacia")
    @Size(min = 5, max = 50, message = "La contrasena debe tener entre 5 y 50 caracteres")
    private String contrasena;

//    Por defecto todas las relaciones ToOne son FetchType.EAGER
//    Y todas las relacion ToMany son FetchType.LAZY
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "perfil_id")
    private Perfil perfil;

    @ManyToMany(mappedBy = "usuarios",cascade = CascadeType.PERSIST)
    private List<Rol> roles;

    @OneToMany(mappedBy = "usuario")
    private List<Publicacion> publicaciones;

    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentarios;

}
