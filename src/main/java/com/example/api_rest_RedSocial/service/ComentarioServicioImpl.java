package com.example.api_rest_RedSocial.service;

import com.example.api_rest_RedSocial.domain.model.Comentario;
import com.example.api_rest_RedSocial.domain.repository.ComentarioRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
class ComentarioServicioImpl implements ComentarioServicio {

    private final ComentarioRepository comentarioRepository;

    public ComentarioServicioImpl(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }
    @Override
    public Comentario save(Comentario comentario){
        return comentarioRepository.save(comentario);
    }
    @Override
    public Optional<Comentario> findById(Integer id){
        return comentarioRepository.findById(id);
    }
    @Override
    public Collection<Comentario> findAll(){
        return comentarioRepository.findAll();
    }
    @Override
    public void delete(Integer id){
        comentarioRepository.deleteById(id);
    }
}
