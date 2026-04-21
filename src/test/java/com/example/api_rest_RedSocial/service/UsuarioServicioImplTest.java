package com.example.api_rest_RedSocial.service;

import com.example.api_rest_RedSocial.domain.model.Usuario;
import com.example.api_rest_RedSocial.domain.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UsuarioServicioImplTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioServicioImpl usuarioServicio;

    @Test
    void readById_DeberiaDevolverUsuario_CuandoElIdExiste(){

        // ------Arrange
        Integer idPrueba=1;
        Usuario usuarioMock = new Usuario();
        usuarioMock.setId(idPrueba);
        usuarioMock.setNombre("Carlos");
        usuarioMock.setContrasena("123456");

        //Mock behaviour
        when(usuarioRepository.findById(idPrueba)).thenReturn(Optional.of(usuarioMock));

        // --------Act
        Optional<Usuario> resultado = usuarioServicio.readById(idPrueba);

        //---------Assert
        assertTrue(resultado.isPresent(), "El resultado deberia estar presente");
        assertEquals("Carlos", resultado.get().getNombre(), "El nombre del usuario no coincide");
        verify(usuarioRepository, times(1)).findById(idPrueba);
    }
}
