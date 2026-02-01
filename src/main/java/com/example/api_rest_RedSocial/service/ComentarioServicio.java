package com.example.api_rest_RedSocial.service;

import com.example.api_rest_RedSocial.domain.model.Comentario;

import java.util.Collection;
import java.util.Optional;

public interface ComentarioServicio {
    Comentario save(Comentario comentario);

    Optional<Comentario> findById(Integer id);

    Collection<Comentario> findAll();

    void delete(Integer id);

}
