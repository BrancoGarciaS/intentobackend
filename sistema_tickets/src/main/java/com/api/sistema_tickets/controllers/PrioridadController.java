package com.api.sistema_tickets.controllers;

import com.api.sistema_tickets.models.PrioridadModel;
import com.api.sistema_tickets.services.PrioridadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/prioridad")  // ruta para trabajar en pgadmin
public class PrioridadController {
    @Autowired
    PrioridadService prioridadService;
    // Para rellenar tabla
    @PostMapping()
    public PrioridadModel savePrioridad(@RequestBody PrioridadModel prioridad){
        return prioridadService.saveData(prioridad);
    }
    // Para obtener tabla
    @GetMapping()
    public List<PrioridadModel> getPrioridad(){
        return prioridadService.getAll();
    }
    // Para obtener fila por id
    @GetMapping("/{id}")
    public Optional<PrioridadModel> getPrioridadById(@PathVariable Long id){
        return prioridadService.getById(id);
    }
    // Para actualizar fila por id
    @PutMapping("/{id}")
    public String updatePrioridadById(@RequestBody PrioridadModel request, @PathVariable Long id){
        return prioridadService.updateById(request,id);
    }
    // Para borrar fila por id
    @DeleteMapping(path = "/{id}")
    public String deletePrioridadById(@PathVariable Long id){
        return prioridadService.deleteById(id);
    }
}
