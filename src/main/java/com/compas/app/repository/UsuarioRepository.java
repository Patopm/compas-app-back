package com.compas.app.repository;

import com.compas.app.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("Select u FROM Usuario u WHERE u.email =?1")
    Optional<Usuario> findUsuarioByEmail(String email);
}
