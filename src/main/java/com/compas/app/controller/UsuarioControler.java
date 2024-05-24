package com.compas.app.controller;


import com.compas.app.model.Usuario;
import com.compas.app.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
public class UsuarioControler {
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioControler(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/usuarios")
    public List<Usuario> getUsuario(){
        return usuarioService.getAllUsers();
    }

    @PostMapping("/addUsuario")
    public Usuario registerNewUsuario(@RequestBody Usuario usuario){
        return usuarioService.addNewUsuario(usuario);
    }

    @DeleteMapping(path = "/usuario/{id_usuario}")
    public void deleteUsuario(@PathVariable("id_usuario") Long id_usuario){
        usuarioService.deleteUsuario(id_usuario);
    }

    @PutMapping(path = "/usuario/{id_usuario}")
    public void updateUsuario(@PathVariable("id_usuario") Long id_usuario,
                              @RequestParam(required = false) String nombre,
                              @RequestParam(required = false) String apellidos,
                              @RequestParam(required = false) Integer edad,
                              @RequestParam(required = false) String email,
                              @RequestParam(required = false) String password,
                              @RequestParam(required = false) String genero,
                              @RequestParam(required = false) Integer codigoPostal,
                              @RequestParam(required = false) String estado,
                              @RequestParam(required = false) String ciudad,
                              @RequestParam(required = false) String foto_perfil,
                              @RequestParam(required = false) String foto_portada){
        usuarioService.updateUsuario(id_usuario,nombre, apellidos, edad, email, password, genero, codigoPostal, estado, ciudad, foto_perfil, foto_portada);
    }
}
