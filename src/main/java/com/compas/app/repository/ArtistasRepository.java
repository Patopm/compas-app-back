package com.compas.app.repository;

import com.compas.app.model.Artistas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistasRepository extends JpaRepository<Artistas, Long> {

    @Query("Select a FROM Artistas a WHERE a.artistaId =?1")
    Optional<Artistas> findArtistaByIdArtista(Long id_artista);
}
