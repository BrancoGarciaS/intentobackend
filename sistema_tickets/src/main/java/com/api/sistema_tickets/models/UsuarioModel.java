package com.api.sistema_tickets.models;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario", unique = true, nullable = false)
    private Long idUsuario; // atributo llave

    @Column(name = "nombreUsuario", nullable = false)
    private String nombreUsuario; // atributo

    @Column(name = "apellidoUsuario", nullable = false)
    private String apellidoUsuario; // atributo

    @Column(name = "correo", nullable = false)
    private String correo; // atributo

    @Column(name = "clave", nullable = false)
    private String clave; // atributo

    // atributo relacionado a area (Relacion muchos a uno, muchos usuarios tienen un area)
    @ManyToOne
    @JoinColumn(name = "id_area")
    private AreaModel id_area;

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public AreaModel getId_area() {
        return id_area;
    }

    public void setId_area(Long id_area) {
        this.id_area = new AreaModel(id_area);
    }


}
