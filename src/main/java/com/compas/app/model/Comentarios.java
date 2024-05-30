package com.compas.app.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "comentarios")
public class Comentarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comentario")
    private Long id_comentario;

    @Column(name = "comentario", nullable = false)
    private String comentario;

    @Column(name = "created_at", updatable = false)
    private LocalDate created_at;

    @Column(name = "updated_at")
    private LocalDate updated_at;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publicacion_id", nullable = false)
    private Publicaciones publicacion;

    public Long getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(Long id_comentario) {
        this.id_comentario = id_comentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Publicaciones getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicaciones publicacion) {
        this.publicacion = publicacion;
    }

    public Comentarios(){

    }

    public Comentarios(Long id_comentario, String comentario, LocalDate created_at, LocalDate updated_at, Usuario usuario, Publicaciones publicacion) {
        this.id_comentario = id_comentario;
        this.comentario = comentario;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.usuario = usuario;
        this.publicacion = publicacion;
    }

    public Comentarios(String comentario, LocalDate created_at, LocalDate updated_at, Usuario usuario, Publicaciones publicacion) {
        this.comentario = comentario;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.usuario = usuario;
        this.publicacion = publicacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comentarios that = (Comentarios) o;
        return Objects.equals(id_comentario, that.id_comentario) && Objects.equals(comentario, that.comentario) && Objects.equals(created_at, that.created_at) && Objects.equals(updated_at, that.updated_at) && Objects.equals(usuario, that.usuario) && Objects.equals(publicacion, that.publicacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_comentario, comentario, created_at, updated_at, usuario, publicacion);
    }

    @Override
    public String toString() {
        return "Comentarios{" +
                "id_comentario=" + id_comentario +
                ", comentario='" + comentario + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", usuario=" + usuario +
                ", publicacion=" + publicacion +
                '}';
    }
}
