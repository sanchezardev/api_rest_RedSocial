package com.example.api_rest_RedSocial.controller;

import com.example.api_rest_RedSocial.domain.model.Usuario;
import com.example.api_rest_RedSocial.service.UsuarioServicio;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioServicio usuarioServicio;

    public UsuarioController(UsuarioServicio usuarioServicio){
        this.usuarioServicio = usuarioServicio;
    }

    @GetMapping("/todos")
    public List<Usuario> findAll(){
        return usuarioServicio.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Usuario> findById(@PathVariable("id") int id){
        return usuarioServicio.findById(id);
    }

    @PostMapping
    public void create(@RequestBody Usuario usuario){
        usuarioServicio.save(usuario);

        //Para poder ejecutar en la consola del navegador
        /*
        fetch('http://localhost:8080/usuario', {
                method: 'POST',
                headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
                nombre: 'Juan Perez',
                contrasena: 'contraseña123'
        })
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Error en la creación del usuario');
            }
            return response.json();
        })
        .then(data => {
                    console.log('Usuario creado con éxito:', data);
        })
        .catch(error => {
                    console.error('Error:', error);
        });
        */
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable("id") int id){
        usuarioServicio.delete(id);

        //Para poder ejecutar en la consola del navegador, el id cambiandolo por el id que queremos eliminar
        /*
        fetch('http://localhost:8080/usuario/id', {
            method: 'DELETE'
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Error al eliminar el usuario');
            }
            console.log('Usuario eliminado con éxito');
        })
        .catch(error => {
            console.error('Error:', error);
        });
        */
    }
}
