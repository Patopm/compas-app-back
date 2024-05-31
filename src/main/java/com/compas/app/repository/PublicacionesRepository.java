package com.compas.app.repository;

import com.compas.app.model.Publicaciones;
import com.compas.app.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PublicacionesRepository extends JpaRepository<Publicaciones, Long> {
    @Query("SELECT p FROM Publicaciones p WHERE p.idPublicacion = ?1")
    Optional<Publicaciones> findPublicacionById(Long id);
}
