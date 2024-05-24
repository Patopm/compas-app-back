package com.compas.app.service;

import com.compas.app.model.Usuario;
import com.compas.app.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;
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


    public Usuario addNewUsuario(Usuario usuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findUsuarioByEmail(usuario.getEmail());
        if(usuarioOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        usuarioRepository.save(usuario);
        return usuario;
    }

    public void deleteUsuario(Long id_usuario) {
        boolean exists =usuarioRepository.existsById(id_usuario);
        if (!exists){
            throw new IllegalStateException("usuario with id" + id_usuario + " does not exist");
        }
        usuarioRepository.deleteById(id_usuario);
    }

    @Transactional
    public void updateUsuario(Long idUsuario,
                              String nombre,
                              String apellidos,
                              Integer edad,
                              String email,
                              String password,
                              String genero,
                              Integer codigoPostal,
                              String estado,
                              String ciudad,
                              String fotoPerfil,
                              String fotoPortada) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new IllegalStateException("user with id " + idUsuario + " does not exist"));
        if (nombre != null && nombre.length() > 0 && !Objects.equals(usuario.getNombre(), nombre)){
            usuario.setNombre(nombre);
        }
        if (apellidos != null && apellidos.length() > 0 && !Objects.equals(usuario.getApellidos(), apellidos)){
            usuario.setApellidos(apellidos);
        }
        if (edad != null && edad > 18 && !Objects.equals(usuario.getEdad(), edad)){
            usuario.setEdad(edad);
        }
        if (email != null && email.length() > 0 && !Objects.equals(usuario.getEmail(), email)){
            usuario.setEmail(email);
        }
        if (password != null && password.length() > 0 && !Objects.equals(usuario.getPassword(), password)){
            usuario.setPassword(password);
        }
        if (genero != null && genero.length() > 0 && !Objects.equals(usuario.getGenero(), genero)){
            usuario.setGenero(genero);
        }
        if (codigoPostal != null && codigoPostal >= 1000 && codigoPostal <= 99000 && !Objects.equals(usuario.getCodigoPostal(), codigoPostal)){
            usuario.setCodigoPostal(codigoPostal);
        }
        if (estado != null && estado.length() > 0 && !Objects.equals(usuario.getEstado(), estado)){
            usuario.setEstado(estado);
        }
        if (ciudad != null && ciudad.length() > 0 && !Objects.equals(usuario.getCiudad(), ciudad)){
            usuario.setCiudad(ciudad);
        }
        if (fotoPerfil != null && fotoPerfil.length() > 0 && !Objects.equals(usuario.getFoto_perfil(), fotoPerfil)){
            usuario.setFoto_perfil(fotoPerfil);
        }
        if (fotoPortada != null && fotoPortada.length() > 0 && !Objects.equals(usuario.getFoto_portada(), fotoPortada)){
            usuario.setFoto_portada(fotoPortada);
        }

    }
}
