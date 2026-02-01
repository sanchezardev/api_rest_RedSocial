package com.example.api_rest_RedSocial.controller;

import com.example.api_rest_RedSocial.domain.model.Perfil;
import com.example.api_rest_RedSocial.service.PerfilServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/perfil")
public class PerfilController {

    //Los logger sirven para registrar mensajes en un fichero
    static final Logger LOGGER = LoggerFactory.getLogger(PerfilController.class);

    private final PerfilServicio perfilServicio;

    public PerfilController(PerfilServicio perfilServicio) {
        this.perfilServicio = perfilServicio;
    }

    @GetMapping("/todos")
    public Collection<Perfil> findAll(){
        LOGGER.info("Entro en la busqueda de todos los perfils");
        Collection<Perfil> all = perfilServicio.findAll();
        LOGGER.info("Hay "+all.size()+" perfils");
        return all;
    }
    @GetMapping("/{id}")
    public Optional<Perfil> findById(@PathVariable("id") int id){
        return perfilServicio.findById(id);
    }
    @PostMapping
    public ResponseEntity<Perfil> create(@RequestBody Perfil perfil){
        LOGGER.info("Creando perfil: {}", perfil);
        Perfil perfilGuardado = perfilServicio.save(perfil);
        return ResponseEntity.ok().body(perfilGuardado);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable("id") int id) {
        perfilServicio.delete(id);
    }
}
