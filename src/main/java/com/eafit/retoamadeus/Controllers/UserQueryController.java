package com.eafit.retoamadeus.Controllers;

import com.eafit.retoamadeus.contracts.request.UserQueryRequest;
import com.eafit.retoamadeus.contracts.request.UserRequest;
import com.eafit.retoamadeus.contracts.responses.UserQueryResponse;
import com.eafit.retoamadeus.contracts.responses.UserResponse;
import com.eafit.retoamadeus.mappers.implementation.UserMapper;
import com.eafit.retoamadeus.mappers.intefaces.UserInterface;
import com.eafit.retoamadeus.mappers.intefaces.UserQueryInterface;
import com.eafit.retoamadeus.models.UserQuerysModel;
import com.eafit.retoamadeus.services.UserQueryService;
import com.eafit.retoamadeus.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/userQueryController")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")


public class UserQueryController {


    private final UserQueryService userService;
    private final UserQueryInterface userMapper;

    @GetMapping ("/list")
    public List<UserQueryResponse> getUsers() {
        return userMapper.mapUserQueryModelListToUserQueryResponseList(userService.findAll());
    }


    // cambio de código
    @PostMapping("/create")
    public UserQueryResponse createUser(@RequestBody UserQueryRequest userRequest) {
        if (userRequest.getUser() == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        UserQuerysModel userQuerysModel = userMapper.mapUserQueryRequestToUserQueryModel(userRequest);
        return userMapper.mapUserQueryModelToUserQueryResponse(userService.save(userQuerysModel));
    }






    /** se le agrega el if para asegura que no sea null
    @PostMapping("/create")
    public UserQueryResponse createUser (@RequestBody UserQueryRequest userRequest) {
    if (userRequest.getUser() == null) {
    throw new IllegalArgumentException("User cannot be null");
    }
        return userMapper.mapUserQueryModelToUserQueryResponse(userService.save(
                        userMapper.mapUserQueryRequestToUserQueryModel(userRequest)));
    }

    */

    @GetMapping("/getById/{id}")
    public UserQueryResponse getUserById(@PathVariable Long id) {
        return userMapper.mapUserQueryModelToUserQueryResponse(userService.findById(id));
    }


}
