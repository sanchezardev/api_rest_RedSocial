package com.example.api_rest_RedSocial.domain.repository;

import com.example.api_rest_RedSocial.domain.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {

}
