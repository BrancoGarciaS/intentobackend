package com.api.sistema_tickets.controllers;

import com.api.sistema_tickets.models.AreaModel;
import com.api.sistema_tickets.models.UsuarioModel;
import com.api.sistema_tickets.services.AreaService;
import com.api.sistema_tickets.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")  // ruta para trabajar
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;
    // Para rellenar tabla
    @PostMapping()
    public UsuarioModel saveArea(@RequestBody UsuarioModel user){
        return usuarioService.saveData(user);
    }
    // Para obtener tabla
    @GetMapping()
    public List<UsuarioModel> getArea(){
        return usuarioService.getAll();
    }
    // Para obtener fila por id
    @GetMapping("/{id}")
    public Optional<UsuarioModel> getAreaById(@PathVariable Long id){
        return usuarioService.getById(id);
    }
    // Para actualizar fila por id
    @PutMapping("/{id}")
    public String updateAreaById(@RequestBody UsuarioModel request, @PathVariable Long id){
        return usuarioService.updateById(request,id);
    }
    // Para borrar fila por id
    @DeleteMapping(path = "/{id}")
    public String deleteAreaById(@PathVariable Long id){
        return usuarioService.deleteById(id);
    }

    @PostMapping("/login")
    public UsuarioModel login(@RequestBody UsuarioModel usuario) {
        return usuarioService.login(usuario);
    }
}
