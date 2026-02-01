package com.example.api_rest_RedSocial.service;

import com.example.api_rest_RedSocial.domain.model.Rol;
import com.example.api_rest_RedSocial.domain.repository.RolRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class RolServicioImpl implements RolServicio{

    private final RolRepository rolRepository;

    public RolServicioImpl(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }
    @Override
    public Rol save(Rol rol){
        return rolRepository.save(rol);
    }
    @Override
    public Optional<Rol> findById(Integer id){
        return rolRepository.findById(id);
    }
    @Override
    public List<Rol> findAll(){
        return rolRepository.findAll();
    }
    @Override
    public void delete(Integer id){
        rolRepository.deleteById(id);
    }
}
