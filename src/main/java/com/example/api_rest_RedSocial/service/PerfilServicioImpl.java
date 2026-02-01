package com.example.api_rest_RedSocial.service;

import com.example.api_rest_RedSocial.domain.model.Perfil;
import com.example.api_rest_RedSocial.domain.repository.PerfilRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
class PerfilServicioImpl implements PerfilServicio {

    private final PerfilRepository perfilRepository;

    public PerfilServicioImpl(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }
    @Override
    public Perfil save(Perfil perfil){
        return perfilRepository.save(perfil);
    }
    @Override
    public Optional<Perfil> findById(int id){
        return perfilRepository.findById(id);
    }
    @Override
    public Collection<Perfil> findAll(){
        return perfilRepository.findAll();
    }
    @Override
    public void delete(Integer id){
        perfilRepository.deleteById(id);
    }
}
