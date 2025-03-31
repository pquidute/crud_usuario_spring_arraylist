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

    @GetMapping("/{id}")
    public User getUserByID(@PathVariable Integer id){
        for (User u : userArrayList){
            if (u.getId() == id){
                return u;
            }
        }
        return null;
    }

    @PostMapping
    public String addUser(@RequestBody User user){
        userArrayList.add(user);
        return user.getName() + " successfully registered!";
    }

    @PutMapping("/{id}")
    public String updateUser(@RequestBody User user, @PathVariable Integer id){
        for (User u : userArrayList){
            if (u.getId().equals(user.getId())){
                u.setName(user.getName());
                return user.getName() + " successfully updated!";
            }
        }
        return "user not found!";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Integer id){
        for (User u : userArrayList){
            if (u.getId() == id){
                userArrayList.remove(u);
                return u.getName() + " successfully deleted!";
            }
        }
        return "user not found!";
    }


}
