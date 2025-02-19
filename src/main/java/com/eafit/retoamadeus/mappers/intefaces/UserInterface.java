package com.eafit.retoamadeus.mappers.intefaces;

import com.eafit.retoamadeus.contracts.request.UserRequest;
import com.eafit.retoamadeus.contracts.responses.UserResponse;
import com.eafit.retoamadeus.entities.UserEntity;
import com.eafit.retoamadeus.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Esta clase representa la entidad de usuario en la base de datos.
 * Se utiliza para mapear los datos de la tabla "users" a un objeto Java. Utilizado en los controladores.
 * 
 * @autor Francisco Echavarría
 * @version 1.0
 */


@Mapper(componentModel = "spring") // Indica que esta interfaz es un mapper de MapStruct y que debe ser gestionado por Spring
public interface UserInterface {

    @Mapping(target = "id", ignore = true) // Ignora el campo 'id' al mapear
    UserEntity mapUserRequestToUserEntity(UserRequest userRequest); // Mapea un objeto UserRequest a un UserEntity

    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())") // Asigna la fecha actual al campo 'createdAt'
    @Mapping(target = "updatedAt", ignore = true) // Ignora el campo 'updatedAt' al mapear
    UserEntity mapUserToUserEntity(User user); // Mapea un objeto User a un UserEntity

    User mapUserEntityToUser(UserEntity userEntity); // Mapea un objeto UserEntity a un User

    @Mapping(target = "id", ignore = true) // Ignora el campo 'id' al mapear
    User mapUserRequestToUser(UserRequest userRequest); // Mapea un objeto UserRequest a un User

    UserRequest mapUserToUserRequest(User user); // Mapea un objeto User a un UserRequest

    UserResponse mapUserToUserResponse(User user); // Mapea un objeto User a un UserResponse

    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())") // Asigna la fecha actual al campo 'createdAt'
    @Mapping(target = "updatedAt", ignore = true) // Ignora el campo 'updatedAt' al mapear
    UserEntity toUserEntity(User user); // Mapea un objeto User a un UserEntity

    UserResponse toUserResponse(UserEntity userEntity); // Mapea un objeto UserEntity a un UserResponse

    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())") // Asigna la fecha actual al campo 'createdAt'
    @Mapping(target = "updatedAt", ignore = true) // Ignora el campo 'updatedAt' al mapear
    UserEntity toUserEntity(UserResponse userResponse); // Mapea un objeto UserResponse a un UserEntity

    List<User> mapUserEntityListToUserModelList(List<UserEntity> entity); // Mapea una lista de UserEntity a una lista de User

    List<UserResponse> mapUserModelListToUserResponseList(List<User> entity); // Mapea una lista de User a una lista de UserResponse

}















