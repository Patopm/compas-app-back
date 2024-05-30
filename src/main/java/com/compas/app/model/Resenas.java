package com.compas.app.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="resenas")
public class Resenas {
    //id_resena, resena, created_at, updated_at, usuario_id, artista_id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_resena")
    private long id_resena;

    @Column(name = "resena", length = 500, nullable = false)
    private String resena;

    @Column(name = "created_at", updatable = false, insertable = false)
    private LocalDate created_at;

    @Column(name = "updated_at", updatable = false, insertable = false)
    private LocalDate updated_at;

    @ManyToOne
    @JoinColumn(name = "id_artista", nullable = false)
    private Artistas artista_id;

    @JoinColumn(name = "id_escenario", nullable = false)
    private Artistas escenario_id;

    //Constructor vacío
    public Resenas() {
    }

    //Constructor sin Id
    public Resenas(String resena, LocalDate created_at, LocalDate updated_at, Artistas artista_id, Artistas escenario_id) {
        this.resena = resena;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.artista_id = artista_id;
        this.escenario_id = escenario_id;
    }

    //Constructor con Id
    public Resenas(long id_resena, String resena, LocalDate created_at, LocalDate updated_at, Artistas artista_id, Artistas escenario_id) {
        this.id_resena = id_resena;
        this.resena = resena;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.artista_id = artista_id;
        this.escenario_id = escenario_id;
    }

    //Equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resenas resenas = (Resenas) o;
        return id_resena == resenas.id_resena && Objects.equals(resena, resenas.resena) && Objects.equals(created_at, resenas.created_at) && Objects.equals(updated_at, resenas.updated_at) && Objects.equals(artista_id, resenas.artista_id) && Objects.equals(escenario_id, resenas.escenario_id);
    }

    //Hashcode
    @Override
    public int hashCode() {
        return Objects.hash(id_resena, resena, created_at, updated_at, artista_id, escenario_id);
    }

    //ToString

    @Override
    public String toString() {
        return "Resenas{" +
                "id_resena=" + id_resena +
                ", resena='" + resena + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", artista_id=" + artista_id +
                ", escenario_id=" + escenario_id +
                '}';
    }
}
