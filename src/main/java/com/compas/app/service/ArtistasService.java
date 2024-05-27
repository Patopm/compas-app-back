package com.compas.app.service;

import com.compas.app.model.Artistas;
import com.compas.app.repository.ArtistasRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ArtistasService {
    private final ArtistasRepository artistasRepository;

    public ArtistasService(ArtistasRepository artistasRepository) {
        this.artistasRepository = artistasRepository;
    }


    public List<Artistas> getAllArtistas() {
        return artistasRepository.findAll();
    }

    public void addNewArtista(Artistas artistas) {
        //Optional<Artistas> optionalArtistas = artistasRepository.findArtistaByArtistaId(artistas.getId_artista());
        //if(optionalArtistas.isPresent()){
        //    throw new IllegalStateException("el usuario con id " + artistas.getId_artista() + " ya existe");
        //}
        artistasRepository.save(artistas);
    }

    public void deleteArtista(Long idArtista) {
        if(artistasRepository.existsById(idArtista)){
            throw new IllegalStateException("el artista con id " + idArtista + " no existe");
        }
        artistasRepository.deleteById(idArtista);
    }

    //@Transactional
    //public void updateArtista(Long id_Artista, String acercaDe) {
        //Artistas artista = artistasRepository.findArtistaByArtistaId(id_Artista)
        //        .orElseThrow(() -> new IllegalStateException("el artista con id " + id_Artista + " no existe"));
        //Artistas artista = artistasRepository.findAllById(id_Artista);
        //if (acercaDe != null && acercaDe.length() > 0 && !Objects.equals(artista.getAcerca_de(), acercaDe)) {
            //artista.setAcerca_de(acercaDe);
        //}
    //}
}