package com.example.api_rest_RedSocial.domain.repository;

import com.example.api_rest_RedSocial.domain.model.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion, Integer> {
}
