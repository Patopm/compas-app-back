package com.compas.app.controller;


import com.compas.app.model.Usuario;
import com.compas.app.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> getAllUsuario(){
        return usuarioService.getAllUsers();
    }

    @PostMapping("/addUsuario")
    public void registerNewUsuario(@RequestBody Usuario usuario){
        usuario.setCreated_at(LocalDate.now());
        usuario.setUpdated_at(LocalDate.now());
        usuarioService.addNewUsuario(usuario);
    }

    @DeleteMapping(path = "/{id_usuario}")
    public void deleteUsuario(@PathVariable("id_usuario") Long id_usuario){
        usuarioService.deleteUsuario(id_usuario);
    }

    @PutMapping(path = "/{id_usuario}")
    public void updateUsuario(@PathVariable("id_usuario") Long id_usuario,
                              @RequestBody(required = false) String nombre,
                              @RequestBody(required = false) String apellidos,
                              @RequestBody(required = false) Integer edad,
                              @RequestBody(required = false) String email,
                              @RequestBody(required = false) String password,
                              @RequestBody(required = false) String genero,
                              @RequestBody(required = false) Integer codigoPostal,
                              @RequestBody(required = false) String estado,
                              @RequestBody(required = false) String ciudad,
                              @RequestBody(required = false) String foto_perfil,
                              @RequestBody(required = false) String foto_portada){
        usuarioService.updateUsuario(id_usuario,nombre, apellidos, edad, email, password, genero, codigoPostal, estado, ciudad, foto_perfil, foto_portada);
    }
}
