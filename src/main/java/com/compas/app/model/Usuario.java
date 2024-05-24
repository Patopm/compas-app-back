package com.compas.app.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Data
@Table(name = "Usuarios")
public class Usuario {
    @Id
    @Column(name = "id_usuario")
    @GeneratedValue()
    private Long id_usuario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "edad")
    private Integer edad;

    @Column(name = "email")
    private String email;

    @Column(name = "contraseña")
    private String password;

    @Column(name = "genero")
    private String genero;

    @Column(name = "codigo_postal")
    private Integer codigoPostal;

    @Column(name = "estado")
    private String estado;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "foto_perfil")
    private String foto_perfil;

    @Column(name = "foto_portada")
    private String foto_portada;

    @Column(name = "created_at", updatable = false, insertable = false)
    private LocalDate created_at;

    @Transient
    private LocalDate updated_at;


    public Usuario() {
    }

    public Usuario(Long id, String nombre, String apellidos, Integer edad, String email, String password, String genero, Integer codigoPostal, String estado, String ciudad, String foto_perfil, String foto_portada, LocalDate created_at) {
        this.id_usuario = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.email = email;
        this.password = password;
        this.genero = genero;
        this.codigoPostal = codigoPostal;
        this.estado = estado;
        this.ciudad = ciudad;
        this.foto_perfil = foto_perfil;
        this.foto_portada = foto_portada;
        this.created_at = created_at;
    }

    public Usuario(String nombre, String apellidos, Integer edad, String email, String password, String genero, Integer codigoPostal, String estado, String ciudad, String foto_perfil, String foto_portada, LocalDate created_at) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.email = email;
        this.password = password;
        this.genero = genero;
        this.codigoPostal = codigoPostal;
        this.estado = estado;
        this.ciudad = ciudad;
        this.foto_perfil = foto_perfil;
        this.foto_portada = foto_portada;
        this.created_at = created_at;
    }

    public Long getId() {
        return id_usuario;
    }

    public void setId(Long id) {
        this.id_usuario = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(Integer codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getFoto_perfil() {
        return foto_perfil;
    }

    public void setFoto_perfil(String foto_perfil) {
        this.foto_perfil = foto_perfil;
    }

    public String getFoto_portada() {
        return foto_portada;
    }

    public void setFoto_portada(String foto_portada) {
        this.foto_portada = foto_portada;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public Period getUpdated_at() {
        return Period.between(this.created_at, LocalDate.now());
    }

    public void setUpdated_at(LocalDate updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id_usuario +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", genero='" + genero + '\'' +
                ", codigoPostal=" + codigoPostal +
                ", estado='" + estado + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", foto_perfil='" + foto_perfil + '\'' +
                ", foto_portada='" + foto_portada + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
