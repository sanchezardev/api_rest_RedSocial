package com.example.api_rest_RedSocial.service;

import com.example.api_rest_RedSocial.domain.model.Publicacion;

import java.util.Collection;
import java.util.Optional;

public interface PublicacionServicio {
    Publicacion save(Publicacion publicacion);

    Optional<Publicacion> findById(Integer id);

    Collection<Publicacion> findAll();

    void delete(Integer id);

}
