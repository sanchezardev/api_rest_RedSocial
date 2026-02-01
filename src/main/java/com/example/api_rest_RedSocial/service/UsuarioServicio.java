package com.example.api_rest_RedSocial.service;

import jakarta.transaction.Transactional;
import com.example.api_rest_RedSocial.domain.model.Usuario;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface UsuarioServicio {

    void save(Usuario usuario);

    Optional<Usuario> readById(Integer id);

    //READ -> By Id
    @Transactional
    Optional<Usuario> readByIdLazyLoad(Integer id);

    Iterable<Usuario> readAll();

    void delete(Integer id);

    List<Usuario> findByName(String name);

    List<Usuario> buscarQueTengaPerfil();

    List<Usuario> buscarQueTengaPerfil1();

    Page<Usuario> find(int page, int size);

    List<Usuario> findAll();

    Optional<Usuario> findById(Integer id);
}
