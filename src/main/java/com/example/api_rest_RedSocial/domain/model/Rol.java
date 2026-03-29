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
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El nombre no puede estar vacio")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    private String nombre;

    @ManyToMany
    @JoinTable(name="usuario_rol",
        joinColumns = @JoinColumn(name ="rol_id"),
        inverseJoinColumns= @JoinColumn(name = "usuario_id"))
    private List<Usuario> usuarios;

}
