package com.example.api_rest_RedSocial.service;

import jakarta.transaction.Transactional;
import com.example.api_rest_RedSocial.domain.model.Usuario;
import com.example.api_rest_RedSocial.domain.repository.UsuarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //Es un @Component de Spring por lo que va a hacer que lo tenga en el contexto. Spring va a crear estos objetos e inyectar el resto de componentes que sean necesarios.
//Impl -> Implementación, es decir, la clase que implementa la interfaz
class UsuarioServicioImpl implements UsuarioServicio {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServicioImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    //CREATE \ UPDATE
    @Override
    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    //READ -> By Id
    @Override
    @Transactional //Abre una transaccion de base de datos lo que va a hacer que las operaciones se ejecuten en un bloque
    public Optional<Usuario> readById(Integer id){
        return usuarioRepository.findById(id);
    }

    //READ -> By Id
//    @Transactional
    @Override
    public Optional<Usuario> readByIdLazyLoad(Integer id){
        Optional<Usuario> byId = usuarioRepository.findById(id);
        byId.ifPresent(usuario1 -> System.out.println(usuario1.getPerfil().toString()));
        return byId;
    }

    //READ ALL
    @Override
    public Iterable<Usuario> readAll(){
        return usuarioRepository.findAll();
    }

    //DELETE
    @Override
    public void delete(Integer id){
        usuarioRepository.deleteById(id);
    }

    //Nuevo metodo para probar los metodos de Spring
    @Override
    public List<Usuario> findByName(String name) {
        return usuarioRepository.findAllByNombre(name);
    }

    @Override
    public List<Usuario> buscarQueTengaPerfil() {
        return usuarioRepository.buscarQueTengaPerfil();
    }

    @Override
    public List<Usuario> buscarQueTengaPerfil1() {
        return usuarioRepository.buscarQueTengaPerfil1();
    }

    @Override
    public Page<Usuario> find(int page, int size){
        return usuarioRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> findById(Integer id){
        return usuarioRepository.findById(id);
    }




//    Optional nos sirve para
//    Avisar de que un metodo o variable puede ser nulo
//    Tiene metodos especificos para evitar comprobaciones manuales de nulos
//    Reduce el numero de posibles errores por no hacer comprobaciones de nulos, es decir, NullPointerExceptions
}
