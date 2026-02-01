package com.example.api_rest_RedSocial.domain.repository;

import com.example.api_rest_RedSocial.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    List<Usuario> findAllByNombre(String name);

    @Query(nativeQuery = true, value = "SELECT * FROM Usuario u WHERE u.nombre = :parametro")
    List<Usuario> findByNombre1(@Param("parametro") String name);

    //    SQL PURO, todo lo que sale aqui son los nombres de tablas y columnas en base de datos
    @Query(nativeQuery = true, value = "SELECT * FROM Usuario u WHERE u.perfil_id is not null")
    List<Usuario> buscarQueTengaPerfil();

//    JPQL PURO, todo lo que sale aqui son los nombres de las clases java y sus atributos
    @Query(value = "SELECT u FROM Usuario u WHERE u.perfil.id is not null")
    List<Usuario> buscarQueTengaPerfil1();
}

