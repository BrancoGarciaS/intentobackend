package com.api.sistema_tickets.controllers;

import com.api.sistema_tickets.models.AreaModel;
import com.api.sistema_tickets.services.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/area")  // ruta para trabajar
public class AreaController {
    @Autowired
    AreaService areaService;
    // Para rellenar tabla
    @PostMapping()
    public AreaModel saveArea(@RequestBody AreaModel user){
        return areaService.saveData(user);
    }
    // Para obtener tabla
    @GetMapping()
    public List<AreaModel> getArea(){
        return areaService.getAll();
    }
    // Para obtener fila por id
    @GetMapping("/{id}")
    public Optional<AreaModel> getAreaById(@PathVariable Long id){
        return areaService.getById(id);
    }
    // Para actualizar fila por id
    @PutMapping("/{id}")
    public String updateAreaById(@RequestBody AreaModel request, @PathVariable Long id){
        return areaService.updateById(request,id);
    }
    // Para borrar fila por id
    @DeleteMapping(path = "/{id}")
    public String deleteAreaById(@PathVariable Long id){
        return areaService.deleteById(id);
    }
}
