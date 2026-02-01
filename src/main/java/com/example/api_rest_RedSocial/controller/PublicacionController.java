package com.example.api_rest_RedSocial.controller;

import com.example.api_rest_RedSocial.domain.model.Publicacion;
import com.example.api_rest_RedSocial.service.PublicacionServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.LoggerFactoryFriend;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/publicacion")
public class PublicacionController {

    static final Logger LOGGER= LoggerFactory.getLogger(PublicacionController.class);

    private final PublicacionServicio publicacionServicio;

    public PublicacionController(PublicacionServicio publicacionServicio){
        this.publicacionServicio=publicacionServicio;
    }
    @GetMapping("/todas")
    public Collection<Publicacion> findAll(){
        LOGGER.info("Entro en la busqueda de las publicaciones");
        Collection<Publicacion> all=publicacionServicio.findAll();
        LOGGER.info("Hay en total: "+all.size()+" publicaciones");
        return all;
    }
    @GetMapping("/{id}")
    public Optional<Publicacion> findById(@PathVariable("id") int id){
        return publicacionServicio.findById(id);
    }
    @PostMapping
    public ResponseEntity<Publicacion> create(@RequestBody Publicacion publicacion){
        LOGGER.info("Creando publicacion: {}", publicacion);
        Publicacion publicacionGuardada=publicacionServicio.save(publicacion);
        return ResponseEntity.ok().body(publicacionGuardada);
        //preguntar a palacios que cojones es esto de arriba exactamente
    }
    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable("id") int id){
        publicacionServicio.delete(id);
        LOGGER.info("Publicacion con id: "+id+" borrada");
    }
}

