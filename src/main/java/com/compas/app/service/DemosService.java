package com.compas.app.service;

import com.compas.app.model.Artistas;
import com.compas.app.model.Demos;
import com.compas.app.repository.DemosRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
@Service
public class DemosService {
    private final DemosRepository demosRepository;

    public DemosService(DemosRepository demosRepository){ this.demosRepository = demosRepository;}

    public List<Demos> getAllDemos(){
        return demosRepository.findAll();
    }

    public Demos addNewDemo(Demos demos) {
        demos.setCreated_at(LocalDate.now());
        demos.setUpdated_at(LocalDate.now());
        demosRepository.save(demos);
        return demos;
    }

    public void deleteDemo(Long id_demo) {
        boolean exists = demosRepository.existsById(id_demo);
        if (!exists){
            throw new IllegalStateException("demo with id" + id_demo + " does not exist");
        }
        demosRepository.deleteById(id_demo);
    }

    @Transactional
    public void updateDemo(Long idDemo,
                           String titulo,
                           String fechaLanzamiento,
                           String link,
                           Artistas idArtista){
        Demos demos = demosRepository.findById(idDemo)
                .orElseThrow(() -> new IllegalStateException("demo with id " + idDemo + " does not exist"));
        if (titulo != null && titulo.length() > 0 && !Objects.equals(demos.getTitulo(), titulo)){
            demos.setTitulo(titulo);
        }
        if (fechaLanzamiento != null && !Objects.equals(demos.getFecha_de_lanzamiento(), fechaLanzamiento)){
            demos.setFecha_de_lanzamiento(fechaLanzamiento);
        }
        if (link != null && link.length() > 0 && !Objects.equals(demos.getLink(), link)){
            demos.setLink(link);
        }
        if (idArtista != null && !Objects.equals(demos.getId_artista(), idArtista)){
            demos.setId_artista(idArtista);
        }
    }


}
