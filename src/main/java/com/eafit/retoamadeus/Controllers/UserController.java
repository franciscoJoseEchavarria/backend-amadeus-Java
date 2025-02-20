package com.eafit.retoamadeus.Controllers;

import com.eafit.retoamadeus.contracts.request.UserRequest;
import com.eafit.retoamadeus.contracts.responses.UserResponse;
import com.eafit.retoamadeus.mappers.implementation.UserMapper;
import com.eafit.retoamadeus.mappers.intefaces.UserInterface;
import com.eafit.retoamadeus.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")

public class UserController {

    private final UserService userService;
    private final UserInterface userMapper;

    // Esto pára que sirve?

    @GetMapping("/list")
    public List<UserResponse> getUsers() {
        return userMapper.mapUserModelListToUserResponseList(userService.findAll());
               // userService.getUsers();
    }

    @PostMapping("/create")
    public UserResponse createUser (@RequestBody UserRequest userRequest) {
        return userMapper.mapUserToUserResponse(userService.create(
                        userMapper.mapUserRequestToUser(userRequest)
                )
        );
    }


   @GetMapping("/getUserByName/{name}")
    public UserResponse getUserByName(@PathVariable String name) {
        return userMapper.mapUserToUserResponse(userService.findByName(name));
    }

    @GetMapping("/getUserByEmail/{email}")
    public UserResponse getUserByEmail(@PathVariable String email) {
        return userMapper.mapUserToUserResponse(userService.findByEmail(email));
    }

    @GetMapping("/getNameAndEmail/{name}/{email}")
    public UserResponse getUserAndEmail(@PathVariable String name, @PathVariable String email) {
        return userMapper.mapUserToUserResponse(userService.findByNameAndEmail(name, email));
    }

    @GetMapping("/getUserById/{id}") // Define un endpoint GET para obtener un usuario por su ID
    public UserResponse getUserById(@PathVariable Long id) { // El ID del usuario se pasa como una variable de ruta
        return userMapper.mapUserToUserResponse(userService.findById(id)); // Llama al servicio para encontrar el usuario por ID y lo mapea a una respuesta de usuario
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }


    @DeleteMapping("/deleteAll")
    public void deleteAllUsers() {
        userService.deleteAllUsers();
    }

    @PostMapping("/createMultipleUsers")
    public List<UserResponse> createMultipleUsers(@RequestBody List<UserRequest> userRequests) {
        return userMapper.mapUserModelListToUserResponseList(userService.createMultipleUsers(
                userRequests.stream()
                        .map(userMapper::mapUserRequestToUser)
                        .collect(Collectors.toList())
        ));
    }
}
