package com.compas.app.repository;

import com.compas.app.model.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {
    @Query("SELECT p FROM Publicaciones p WHERE p.idPublicacion = ?1")
    Optional<Publicacion> findPublicacionById(Long id);
}
