package com.compas.app.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "seguidores")
public class Seguidores {

    @OneToOne
    private Long id_seguidor;

    @Column(name = "seguidor_tipo")
    private String seguidor_tipo;

    @OneToOne
    private Long id_seguido;

    @Column(name = "seguidor_tipo")
    private String seguido_tipo;

    @Column(name = "created_at", updatable = false, insertable = false)
    private Date created_at;

    @Column(name = "updated_at", insertable = false)
    private Date updated_at;

    public Seguidores() {
    }

    public Seguidores(String seguidor_tipo, Long id_seguido, String seguido_tipo, Date created_at, Date updated_at) {
        this.seguidor_tipo = seguidor_tipo;
        this.id_seguido = id_seguido;
        this.seguido_tipo = seguido_tipo;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Seguidores(Long id_seguidor, String seguidor_tipo, Long id_seguido, String seguido_tipo, Date created_at, Date updated_at) {
        this.id_seguidor = id_seguidor;
        this.seguidor_tipo = seguidor_tipo;
        this.id_seguido = id_seguido;
        this.seguido_tipo = seguido_tipo;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Long getId_seguidor() {
        return id_seguidor;
    }

    public void setId_seguidor(Long id_seguidor) {
        this.id_seguidor = id_seguidor;
    }

    public String getSeguidor_tipo() {
        return seguidor_tipo;
    }

    public void setSeguidor_tipo(String seguidor_tipo) {
        this.seguidor_tipo = seguidor_tipo;
    }

    public Long getId_seguido() {
        return id_seguido;
    }

    public void setId_seguido(Long id_seguido) {
        this.id_seguido = id_seguido;
    }

    public String getSeguido_tipo() {
        return seguido_tipo;
    }

    public void setSeguido_tipo(String seguido_tipo) {
        this.seguido_tipo = seguido_tipo;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seguidores that = (Seguidores) o;
        return Objects.equals(id_seguidor, that.id_seguidor) && Objects.equals(seguidor_tipo, that.seguidor_tipo) && Objects.equals(id_seguido, that.id_seguido) && Objects.equals(seguido_tipo, that.seguido_tipo) && Objects.equals(created_at, that.created_at) && Objects.equals(updated_at, that.updated_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_seguidor, seguidor_tipo, id_seguido, seguido_tipo, created_at, updated_at);
    }

    @Override
    public String toString() {
        return "Seguidores{" +
                "id_seguidor=" + id_seguidor +
                ", seguidor_tipo='" + seguidor_tipo + '\'' +
                ", id_seguido=" + id_seguido +
                ", seguido_tipo='" + seguido_tipo + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
