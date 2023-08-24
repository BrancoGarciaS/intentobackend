package com.api.crud.services;

import com.api.crud.models.UserModel;
import com.api.crud.repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository; // el repositorio de la clase

    public List<UserModel> getUsers(){
        return userRepository.findAll(); // muestratodo
    }
    public UserModel saveUser(UserModel user){
        return userRepository.save(user);
    }
    // optional puede retornar algo o null, metodo para mostrar por un tipo de dato
    public Optional<UserModel> getById(Long id){
        return userRepository.findById(id);
    }

    // en request iria cada dato actualizado
    public UserModel updateById(UserModel request, Long id){
        UserModel user = userRepository.findById(id).get();

        user.setName(request.getName());
        user.setLastname(request.getLastname());
        user.setEmail(request.getEmail());

        userRepository.save(user);

        return user;
    }

    // metodo para eliminar
    public Boolean deleteUser (Long id){
        try{
            userRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }

    }

}
