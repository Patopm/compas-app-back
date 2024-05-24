package com.compas.app.service;

import com.compas.app.model.Usuario;
import com.compas.app.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;


    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public ArrayList<Usuario> getUsers(){
        return (ArrayList<Usuario>) usuarioRepository.findAll();
    }


    public void addNewUsuario(Usuario usuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findUsuarioByEmail(usuario.getEmail());
        if(usuarioOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        usuarioRepository.save(usuario);
    }

    public void deleteUsuario(Long id_usuario) {
        boolean exists =usuarioRepository.existsById(id_usuario);
        if (!exists){
            throw new IllegalStateException("usuario with id" + id_usuario + " does not exist");
        }
        usuarioRepository.deleteById(id_usuario);
    }
}
