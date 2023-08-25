package com.api.sistema_tickets.repositories;

import com.api.sistema_tickets.models.AreaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // permite hacer consultas a la base de datos JpaRepository<NombreClaseModelo, tipoDatoId>
public interface AreaRepository extends JpaRepository<AreaModel, Long> {

}
