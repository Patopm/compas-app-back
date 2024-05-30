package com.compas.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "generos_musicales")
public class generos_musicales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "genero", nullable = false, length = 50, unique = true)
    private String genero;

    @Column(name = "localdate", nullable = false, length = 50, updatable = false, insertable = false)
    private LocalDate created_at;

    @Column(name = "localdate", nullable = false, length = 50)
    private LocalDate updated_at;

    @ManyToMany(mappedBy = "id_artista")
    @JoinColumn()
    private Artistas artistaId;
}
