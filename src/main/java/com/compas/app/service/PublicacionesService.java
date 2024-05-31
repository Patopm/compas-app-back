package com.compas.app.service;

import com.compas.app.exceptions.PublicacionNotFoundException;
import com.compas.app.model.Publicacion;
import com.compas.app.repository.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicacionService {
    private final PublicacionRepository publicacionesRepository;

    @Autowired
    public PublicacionService(PublicacionRepository publicacionesRepository) {
        this.publicacionesRepository = publicacionesRepository;
    }

    //Métodos para get
    public List<Publicacion> getAllPublicaciones() {
        return publicacionesRepository.findAll();
    }

    public Publicacion getPublicacionById(Long id){
        return publicacionesRepository.findPublicacionById(id)
                .orElseThrow(()-> new PublicacionNotFoundException(id));
    }

    //Métodos para post
    public void addNewPublicacion(Publicacion publicaciones){
        Optional<Publicacion> publicacionesOptional = publicacionesRepository.findPublicacionById(publicaciones.getIdPublicacion());
        if(publicacionesOptional.isPresent()){
            throw new IllegalStateException("Publicacion con id " + publicaciones.getIdPublicacion());
        }
        publicacionesRepository.save(publicaciones);
    }

    //Método para delete
    public void deleteById(Long id) {
        publicacionesRepository.deleteById(id);
    }

    public void deletePublicacion(Long id) {
        boolean exists = publicacionesRepository.existsById(id);
        if(!exists){
            throw new PublicacionNotFoundException(id);
        }
        publicacionesRepository.deleteById(id);
    }
}
