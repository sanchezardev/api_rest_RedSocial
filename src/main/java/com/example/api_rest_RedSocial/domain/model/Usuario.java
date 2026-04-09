package com.example.api_rest_RedSocial.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@JsonSerialize
@Getter
@Setter
@NoArgsConstructor
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El nombre no puede estar vacio")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    private String nombre;

    @NotBlank(message = "La contrasena no puede estar vacia")
    @Size(min = 5, max = 255, message = "La contrasena debe tener entre 5 y 255 caracteres")
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

    // Metodos para userDetails

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //Por ahora devolvemos una lista vacia
        return List.of();
    }
    @Override
    @JsonIgnore
    public String getPassword(){
        return this.contrasena;
    }
    @Override
    @JsonIgnore
    public String getUsername(){
        return this.nombre;
    }

    //Estos 4 metodos indican que la cuenta esta activa y no esta bloqueada
    //Al devolver "true", le decimos a Spring que el usuario tiene permiso para acceder.

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired(){
        return true;
    }
    @Override
    @JsonIgnore
    public boolean isAccountNonLocked(){
        return true;
    }
    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired(){
        return true;
    }
    @Override
    @JsonIgnore
    public boolean isEnabled(){
        return true;
    }
}
