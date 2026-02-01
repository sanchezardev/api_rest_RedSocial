package com.example.api_rest_RedSocial.controller;

import com.example.api_rest_RedSocial.domain.model.Comentario;
import com.example.api_rest_RedSocial.service.ComentarioServicio;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {

    //Los logger sirven para registrar mensajes en un fichero
    static final Logger LOGGER = LoggerFactory.getLogger(ComentarioController.class);

    private final ComentarioServicio comentarioServicio;

    public ComentarioController(ComentarioServicio comentarioServicio) {
        this.comentarioServicio = comentarioServicio;
    }

    @GetMapping("/todos")
    public Collection<Comentario> findAll(){
        LOGGER.info("Entro en la busqueda de todos los comentarios");
        Collection<Comentario> all = comentarioServicio.findAll();
        LOGGER.info("Hay "+all.size()+" comentarios");
        return all;
    }
    @GetMapping("/{id}")
    public Optional<Comentario> findById(@PathVariable("id") int id){
        return comentarioServicio.findById(id);
    }
    @PostMapping
    public ResponseEntity<Comentario> create(@RequestBody Comentario comentario){
        LOGGER.info("Creando comentario: {}", comentario);
        Comentario comentarioGuardado = comentarioServicio.save(comentario);
        return ResponseEntity.ok().body(comentarioGuardado);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable("id") int id) {
        comentarioServicio.delete(id);
    }
}
