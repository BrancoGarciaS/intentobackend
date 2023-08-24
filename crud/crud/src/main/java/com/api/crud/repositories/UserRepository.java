package com.api.crud.repositories;

import com.api.crud.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // permite hacer consultas a la base de datos JpaRepository<NombreClaseModelo, tipoDatoId>
public interface UserRepository extends JpaRepository<UserModel, Long> {

}
