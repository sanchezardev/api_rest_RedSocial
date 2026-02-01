package com.example.api_rest_RedSocial.domain.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;

    @ManyToMany
    @JoinTable(name="usuario_rol",
        joinColumns = @JoinColumn(name ="rol_id"),
        inverseJoinColumns= @JoinColumn(name = "usuario_id"))
    private List<Usuario> usuarios;

    public Rol(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
