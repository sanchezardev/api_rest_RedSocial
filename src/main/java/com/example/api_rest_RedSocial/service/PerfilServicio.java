package com.example.api_rest_RedSocial.service;

import com.example.api_rest_RedSocial.domain.model.Perfil;

import java.util.Collection;
import java.util.Optional;

public interface PerfilServicio {
    Perfil save(Perfil perfil);

    Optional<Perfil> findById(int id);

    Collection<Perfil> findAll();

    void delete(Integer id);

}
