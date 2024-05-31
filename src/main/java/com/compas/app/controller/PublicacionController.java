package com.compas.app.controller;

import com.compas.app.model.Publicaciones;
import com.compas.app.service.PublicacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/publicacion")
@CrossOrigin(origins="*", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
public class PublicacionController {
    private final PublicacionesService publicacionesService;

    @Autowired
    public PublicacionController(PublicacionesService publicacionesService) {
        this.publicacionesService = publicacionesService;
    }

    //Get
    @GetMapping
    public List<Publicaciones> getAllPublicaciones(){
        return publicacionesService.getAllPublicaciones();
    }

    @GetMapping("/{id}")
    public Publicaciones getPublicacionesById(@PathVariable(name = "id") Long id){
        return publicacionesService.getPublicacionById(id);
    }

    //Post
    @PostMapping(value = "/add-publicacion", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void registerNewPublicacion(@RequestBody Publicaciones publicaciones){
        publicaciones.setCreatedAt(LocalDateTime.now());
        publicaciones.setUpdatedAt(LocalDateTime.now());
        publicacionesService.addNewPublicacion(publicaciones);
    }

    //Delete
    @DeleteMapping(path = "/{id}")
    public void deletePublicacion(@PathVariable(name = "id")Long id){
        publicacionesService.deletePublicacion(id);
    }
}
