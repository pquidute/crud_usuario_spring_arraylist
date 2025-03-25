package com.senai.crud_usuario_spring_arraylist.controller;

import com.senai.crud_usuario_spring_arraylist.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/users")
public class UserController {
    private ArrayList<User> userArrayList = new ArrayList<>();
    @GetMapping
    public ArrayList<User> getUsers(){
        return userArrayList;
    }

    @PostMapping
    public String addUser(@RequestBody User user){
        userArrayList.add(user);
        return user.getName() + " successfully registered!";
    }

    @PutMapping
    public String updateUser(@RequestBody User user){
        for (User u : userArrayList){
            if (u.getId().equals(user.getId())){
                u.setName(user.getName());
                return user.getName() + " successfully updated!";
            }
        }
        return "user not found!";
    }

    @DeleteMapping
    public String deleteUser(@RequestBody User user){
        for (User u : userArrayList){
            if (u.getId().equals(user.getId())){
                userArrayList.remove(u);
                return user.getName() + " successfully deleted!";
            }
        }
        return "user not found!";
    }


}
