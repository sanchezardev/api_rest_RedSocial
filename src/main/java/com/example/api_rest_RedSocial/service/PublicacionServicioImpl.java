package com.example.api_rest_RedSocial.service;

import com.example.api_rest_RedSocial.domain.model.Publicacion;
import com.example.api_rest_RedSocial.domain.repository.PublicacionRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class PublicacionServicioImpl implements PublicacionServicio{

    private final PublicacionRepository publicacionRepository;

    public PublicacionServicioImpl(PublicacionRepository publicacionRepository){
        this.publicacionRepository=publicacionRepository;
    }
    @Override
    public Publicacion save(Publicacion publicacion){
        return publicacionRepository.save(publicacion);
    }
    @Override
    public Optional<Publicacion> findById(Integer id){
        return publicacionRepository.findById(id);
    }
    @Override
    public Collection<Publicacion> findAll(){
        return publicacionRepository.findAll();
    }
    @Override
    public void delete(Integer id){
        publicacionRepository.deleteById(id);
    }
}
