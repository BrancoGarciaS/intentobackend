package com.api.sistema_tickets.models;

import jakarta.persistence.*;

@Entity
@Table(name = "prioridad")
public class PrioridadModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idArea", unique = true, nullable = false)
    private Long idProridad; // atributo llave

    @Column(name = "nombrePrioridad", nullable = false)
    private String nombrePrioridad; // atributo

    // getters y atributos

    public Long getIdProridad() {
        return idProridad;
    }

    public void setIdProridad(Long idProridad) {
        this.idProridad = idProridad;
    }

    public String getNombrePrioridad() {
        return nombrePrioridad;
    }

    public void setNombrePrioridad(String nombrePrioridad) {
        this.nombrePrioridad = nombrePrioridad;
    }
}
