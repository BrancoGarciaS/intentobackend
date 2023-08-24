package com.api.crud.controllers;

import com.api.crud.models.UserModel;
import com.api.crud.repositories.UserRepository;
import com.api.crud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    //@Autowired //private UserRepository userRepository;
    @PostMapping()
    public UserModel saveUser(@RequestBody UserModel user){
        return userService.saveUser(user);
    }
    @GetMapping()
    public List<UserModel> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public Optional<UserModel> getUserById(@PathVariable Long id){
        return userService.getById(id);
    }

    @PutMapping("/{id}")
    public UserModel updateUserById(@RequestBody UserModel request, @PathVariable Long id){
        return userService.updateById(request,id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        try{
            userService.deleteUser(id);
            return "User with id " + id + " deleted";
        } catch (Exception e){
            return "User with id " + id + " not found";
        }
        /*
        boolean ok = this.userService.deleteUser(id);

        if (ok) {
            return "User with id " + id + " deleted";
        } else {
            return "User with id " + id + " not found";
        }*/

    }

}
