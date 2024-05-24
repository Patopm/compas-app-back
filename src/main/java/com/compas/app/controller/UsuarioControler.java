package com.compas.app.controller;


import com.compas.app.model.Usuario;
import com.compas.app.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "api/v1")
public class UsuarioControler {
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioControler(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/users")
    public ArrayList<Usuario> getUsuario(){
        return usuarioService.getUsers();
    }

    @PostMapping(path = "/addUser")
    public Usuario registerNewUsuario(@RequestBody Usuario usuario){
        return usuarioService.addNewUsuario(usuario);
    }

    @DeleteMapping(path = "{id_usuario}")
    public void deleteUsuario(@PathVariable("id_usuario") Long id_usuario){
        usuarioService.deleteUsuario(id_usuario);
    }
}
