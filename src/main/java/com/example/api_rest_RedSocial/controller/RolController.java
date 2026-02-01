package com.example.api_rest_RedSocial.controller;

import com.example.api_rest_RedSocial.domain.model.Rol;
import com.example.api_rest_RedSocial.service.RolServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
public class RolController {

    static final Logger LOGGER= LoggerFactory.getLogger(RolController.class);

    private final RolServicio rolServicio;

    public RolController(RolServicio rolServicio){
        this.rolServicio=rolServicio;
    }
    @GetMapping("/todos")
    public List<Rol> findAll(){
        LOGGER.info("Entro en la busqueda de roles");
        List<Rol> all=rolServicio.findAll();
        LOGGER.info("Hay un total de: "+all.size()+" roles");
        return all;
    }
    @GetMapping(value="/{id}")
    public Optional<Rol> findById(@PathVariable("id") int id){
        return rolServicio.findById(id);
    }
    @PostMapping
    public void create(@RequestBody Rol rol){
        rolServicio.save(rol);
    }
    @DeleteMapping(value="/{id}")
    public void deleteById(@PathVariable("id") int id){
        rolServicio.delete(id);
    }
}
