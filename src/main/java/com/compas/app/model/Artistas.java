package com.compas.app.model;

import jakarta.persistence.*;
import org.springframework.cache.aspectj.JCacheCacheAspect;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "artistas")
public class Artistas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_artista")
    private Long artistaId;

    @Column(name = "acerca_de")
    private String acerca_de;

    @Column(name = "created_at")
    private LocalDate created_at;

    @Column(name = "updated_at")
    private LocalDate updated_at;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario id_usuario;

    public Artistas() {
    }

    public Artistas(String acerca_de, LocalDate created_at, LocalDate updated_at){ //, Long usuario_id) {
        this.acerca_de = acerca_de;
        this.created_at = created_at;
        this.updated_at = updated_at;
        //this.usuario_id = usuario_id;
    }

    public Artistas(Long id_artista, String acerca_de, LocalDate created_at, LocalDate updated_at){ //, Long usuario_id) {
        this.artistaId = id_artista;
        this.acerca_de = acerca_de;
        this.created_at = created_at;
        this.updated_at = updated_at;
        //this.usuario_id = usuario_id;
    }

    public Long getId_artista() {
        return artistaId;
    }

    public void setId_artista(Long id_artista) {
        this.artistaId = id_artista;
    }

    public String getAcerca_de() {
        return acerca_de;
    }

    public void setAcerca_de(String acerca_de) {
        this.acerca_de = acerca_de;
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
/*
    public Long getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }
*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artistas artistas = (Artistas) o;
        return Objects.equals(artistaId, artistas.artistaId) && Objects.equals(acerca_de, artistas.acerca_de) && Objects.equals(created_at, artistas.created_at) && Objects.equals(updated_at, artistas.updated_at);// && Objects.equals(usuario_id, artistas.usuario_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artistaId, acerca_de, created_at, updated_at);//, usuario_id);
    }

    @Override
    public String toString() {
        return "Artistas{" +
                "id_artista=" + artistaId +
                ", acerca_de='" + acerca_de + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                //", usuario_id=" + usuario_id +
                '}';
    }
}
