package com.api.sistema_tickets.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "area")
@Data
public class AreaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idArea", unique = true, nullable = false)
    private Long idArea; // atributo llave

    @Column(name = "nombreArea", nullable = false)
    private String nombreArea; // atributo
    @Column(name = "descripcion")
    private String descripcion; // atributo

    // atributos relacionados a llaves foraneas (un area pertenece a muchos usuarios)
    @OneToMany(mappedBy = "id_area")
    @JsonIgnore
    private List<UsuarioModel> usuarios; // una lista de usuarios tendrian un area

    // Constructor al ser una entidad que va a ser vinculada tras una FK a otra
    public AreaModel(long id_area){
        this.idArea = id_area;
    }

    // getters y setters
    public Long getIdArea() {
        return idArea;
    }

    public void setIdArea(Long idArea) {
        this.idArea = idArea;
    }

    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<UsuarioModel> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<UsuarioModel> usuarios) {
        this.usuarios = usuarios;
    }
}
