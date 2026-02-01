package com.example.api_rest_RedSocial.service;

import com.example.api_rest_RedSocial.domain.model.Rol;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface RolServicio {
    Rol save(Rol rol);

    Optional<Rol> findById(Integer id);

    List<Rol> findAll();

    void delete(Integer id);
}
