package com.api.sistema_tickets.services;

import com.api.sistema_tickets.models.AreaModel;
import com.api.sistema_tickets.repositories.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AreaService {
    @Autowired
    AreaRepository areaRepository; // el repositorio de la clase

    // Para mostrar todo (get)
    public List<AreaModel> getAll(){
        return areaRepository.findAll();
    }
    // Para postear (post)
    public AreaModel saveData(AreaModel data){
        return areaRepository.save(data);
    }
    // Para mostrar por id (get)
    public Optional<AreaModel> getById(Long id){
        return areaRepository.findById(id);
    }
    // Para actualizar por id (post)
    public String updateById(AreaModel request, Long id){
        // request es los datos ingresados en el post
        AreaModel area;
        try {
            area = areaRepository.findById(id).get();
            if(request.getNombreArea() != null){
                area.setNombreArea(request.getNombreArea());
            }
            if(request.getDescripcion() != null){
                area.setDescripcion(request.getDescripcion());
            }
            areaRepository.save(area);
            return "Area con id " + id + " actualizada";
        }catch (Exception e){
            return "Actualizacion fallida (no existe el id " + id + ")";
        }
    }
    // Para borrar por id (delete)
    public String deleteById (Long id){
        try {
            areaRepository.deleteById(id);
            return "Area eliminada";
        } catch (Exception e) {
            return "No existe area con este ID";
        }
    }
}
