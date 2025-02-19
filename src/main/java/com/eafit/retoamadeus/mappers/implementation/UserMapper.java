package com.eafit.retoamadeus.mappers.implementation;

import com.eafit.retoamadeus.contracts.request.UserRequest;
import com.eafit.retoamadeus.contracts.responses.UserResponse;
import com.eafit.retoamadeus.entities.UserEntity;
import com.eafit.retoamadeus.models.User;
import org.springframework.stereotype.Component;

/**
 * Esta clase representa la entidad de usuario en la base de datos.
 * Se utiliza para mapear los datos de la tabla "users" a un objeto Java. "principalmente utilizado en los servicios, no el los controladores. DTO"
 * Son interfaces que definen métodos para convertir entre diferentes representaciones de datos.
Utilizan herramientas como MapStruct para generar automáticamente el código de mapeo, en este userMapper no se utiliza herramientas Mapstructure, pero en las interfaces si, distintas formas de hacer lo mismo.
Ejemplos en tu proyecto: UserMapper, UserInterface.
 * @autor Francisco Echavarría
 * @version 1.0
 */

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
