package com.eafit.retoamadeus.mappers.implementation;

import com.eafit.retoamadeus.contracts.request.UserRequest;
import com.eafit.retoamadeus.contracts.responses.UserResponse;
import com.eafit.retoamadeus.entities.UserEntity;
import com.eafit.retoamadeus.models.User;
import org.springframework.stereotype.Component;

@Component

public class UserMapper {


    // Mapea un objeto User a un objeto UserEntity
    public UserEntity mapUserModelToUserEntity(User user) {
        return  UserEntity.builder()
                .id(user.getId()) // Convertir Long a String
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }

    public User mapUserEntityToUser(UserEntity userEntity) {
        return User.builder()
                .id(userEntity.getId()) // Convertir String a Long
                .name(userEntity.getName())
                .email(userEntity.getEmail())
                .role(userEntity.getRole())
                .build();
    }

    public User mapUserRequestToUser(UserRequest userRequest) {
        return User.builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .role(userRequest.getRole())
                .build();
    }

       public UserRequest mapUserToUserRequest(User user) {
         return UserRequest.builder()
              .name(user.getName())
              .email(user.getEmail())
              .role(user.getRole())
              .build();
     }

    public UserResponse mapUserToUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole())
                .build();

    }



}
