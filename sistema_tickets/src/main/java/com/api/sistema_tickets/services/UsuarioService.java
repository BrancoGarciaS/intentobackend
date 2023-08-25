package com.api.sistema_tickets.services;

import com.api.sistema_tickets.models.AreaModel;
import com.api.sistema_tickets.models.UsuarioModel;
import com.api.sistema_tickets.repositories.AreaRepository;
import com.api.sistema_tickets.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository; // el repositorio de la clase

    // Para mostrar todo (get)
    public List<UsuarioModel> getAll(){
        return usuarioRepository.findAll();
    }
    // Para postear (post)
    public UsuarioModel saveData(UsuarioModel data){
        return usuarioRepository.save(data);
    }
    // Para mostrar por id (get)
    public Optional<UsuarioModel> getById(Long id){
        return usuarioRepository.findById(id);
    }
    // Para actualizar por id (post)
    public String updateById(UsuarioModel request, Long id){
        // request es los datos ingresados en el post
        UsuarioModel user;
        try {
            user = usuarioRepository.findById(id).get();
            if(request.getNombreUsuario() != null){
                user.setNombreUsuario(request.getNombreUsuario());
            }
            if(request.getApellidoUsuario() != null){
                user.setApellidoUsuario(request.getApellidoUsuario());
            }
            if(request.getClave() != null){
                user.setClave(request.getClave());
            }
            if(request.getCorreo() != null){
                user.setCorreo(request.getCorreo());
            }
            if (request.getId_area() != null) {
                user.setId_area(request.getId_area().getIdArea());
            }
            usuarioRepository.save(user);
            return "Area con id " + id + " actualizada";
        }catch (Exception e){
            return "Actualizacion fallida (no existe el id " + id + ")";
        }
    }
    // Para borrar por id (delete)
    public String deleteById (Long id){
        try {
            usuarioRepository.deleteById(id);
            return "Area eliminada";
        } catch (Exception e) {
            return "No existe area con este ID";
        }
    }

    // Retornara el usuario para iniciar sesion
    public UsuarioModel login(UsuarioModel usuario) {
        try {
            UsuarioModel logUser = usuarioRepository.getUsuarioByCorreo(usuario.getCorreo()).get();

            if (logUser.getClave().equals(usuario.getClave())) {
                // en caso que la clave ingresada (con el correo del usuario de entrada)
                // sea igual a la clave que está en la base de datos con ese correo
                return logUser;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
