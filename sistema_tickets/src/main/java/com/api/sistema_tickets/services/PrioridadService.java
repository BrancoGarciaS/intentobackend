package com.api.sistema_tickets.services;

import com.api.sistema_tickets.models.PrioridadModel;
import com.api.sistema_tickets.repositories.PrioridadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrioridadService {
    @Autowired
    PrioridadRepository prioridadRepository; // el repositorio de la clase

    // Para mostrar todo (get)
    public List<PrioridadModel> getAll(){
        return prioridadRepository.findAll();
    }
    // Para postear (post)
    public PrioridadModel saveData(PrioridadModel prioridad){
        return prioridadRepository.save(prioridad);
    }
    // Para mostrar por id (get)
    public Optional<PrioridadModel> getById(Long id){
        return prioridadRepository.findById(id);
    }
    // Para actualizar por id (post)
    public String updateById(PrioridadModel request, Long id){
        // request es los datos ingresados en el post
        PrioridadModel prioridad;
        try {
            prioridad = prioridadRepository.findById(id).get();
            if(request.getNombrePrioridad() != null){
                prioridad.setNombrePrioridad(request.getNombrePrioridad());
            }
            prioridadRepository.save(prioridad);
            return "Prioridad con id " + id + " actualizada";
        }catch (Exception e){
            return "Actualizacion fallida (no existe el id " + id + ")";
        }
    }
    // Para borrar por id (delete)
    public String deleteById (Long id){
        try {
            prioridadRepository.deleteById(id);
            return "Prioridad eliminada";
        } catch (Exception e) {
            return "No existe prioridad con este ID";
        }
    }
}
