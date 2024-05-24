package com.compas.app.config;

import com.compas.app.model.Usuario;
import com.compas.app.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class UsuarioConfig {
    @Bean
    CommandLineRunner commandLineRunner(UsuarioRepository repository){
        return args -> {
            Usuario patricio = new Usuario(
                    "Patricio",
                    "Piña",
                    18,
                    "egs.pato.pm@gmail.com",
                    "Pato123#",
                    "Masculino",
                    76177,
                    "Querétaro",
                    "Querétaro",
                    "",
                    "",
                    LocalDate.now()
            );
        repository.saveAll(List.of(patricio));
        };
    }
}
