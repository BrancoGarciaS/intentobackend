package com.api.sistema_tickets.repositories;

import com.api.sistema_tickets.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    // Operaciones
    Optional<UsuarioModel> getUsuarioByCorreo(String correo);
}
