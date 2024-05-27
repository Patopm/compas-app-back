package com.compas.app.repository;

import com.compas.app.model.Artistas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistasRepository extends JpaRepository<Artistas, Long> {

    //@Query("Select a FROM Artistas a WHERE a.id_artista =?1")
    //Optional<Artistas> findArtistaByArtistaId(Long id_artista);
}
