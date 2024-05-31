package com.compas.app.model;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "generos_musicales")
public class Generos_musicales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "genero_musical", nullable = false, length = 50, unique = true)
    private String genero_musical;

    @Column(name = "created_at", updatable = false)
    private LocalDate created_at;

    @Column(name = "Updated_at")
    private LocalDate updated_at;

    @ManyToMany (mappedBy = "id_genero_musical")
    private List<Artistas> artistaId;

    @PrePersist
    protected void onCreate(){
        this.created_at = LocalDate.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updated_at = LocalDate.now();
    }

    public Generos_musicales() {
    }

    public Generos_musicales(String genero_musical, LocalDate created_at, LocalDate updated_at, List<Artistas> artistaId) {
        this.genero_musical = genero_musical;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.artistaId = artistaId;
    }

    public Generos_musicales(Long id, String genero_musical, LocalDate created_at, LocalDate updated_at, List<Artistas> artistaId) {
        this.id = id;
        this.genero_musical = genero_musical;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.artistaId = artistaId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenero_musical() {
        return genero_musical;
    }

    public void setGenero_musical(String genero_musical) {
        this.genero_musical = genero_musical;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public LocalDate getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDate updated_at) {
        this.updated_at = updated_at;
    }

    public List<Artistas> getArtistaId() {
        return artistaId;
    }

    public void setArtistaId(List<Artistas> artistaId) {
        this.artistaId = artistaId;
    }

    @Override
    public String toString() {
        return "Generos_musicales{" +
                "id=" + id +
                ", genero_musical='" + genero_musical + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", artistaId=" + artistaId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Generos_musicales that = (Generos_musicales) o;
        return Objects.equals(id, that.id) && Objects.equals(genero_musical, that.genero_musical) && Objects.equals(created_at, that.created_at) && Objects.equals(updated_at, that.updated_at) && Objects.equals(artistaId, that.artistaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, genero_musical, created_at, updated_at, artistaId);
    }
}
