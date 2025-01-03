package com.eafit.retoamadeus.mappers.intefaces;

import com.eafit.retoamadeus.contracts.request.UserQueryRequest;
import com.eafit.retoamadeus.contracts.request.UserRequest;
import com.eafit.retoamadeus.contracts.responses.UserQueryResponse;
import com.eafit.retoamadeus.contracts.responses.UserResponse;
import com.eafit.retoamadeus.entities.UserEntity;
import com.eafit.retoamadeus.entities.UserQueryEntity;
import com.eafit.retoamadeus.models.User;
import com.eafit.retoamadeus.models.UserQuerysModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")

public interface UserQueryInterface {

    @Mapping(target = "id", ignore = true)
    UserQueryEntity mapUserRequestToUserEntity(UserQueryRequest userQueryRequest);

    //voy aca

    UserQueryEntity mapUserQueryModelToUserQueryEntity(UserQuerysModel userQuerysModel); // Mapea un objeto User a un UserEntity

    UserQuerysModel mapUserQueryEntityToUserQueryModel (UserQueryEntity userQueryEntity); // Mapea un objeto UserEntity a un User

    @Mapping(target = "id", ignore = true) // Ignora el campo 'id' al mapear
    UserQuerysModel mapUserQueryRequestToUserQueryModel( UserQueryRequest userQueryRequest); // Mapea un objeto UserRequest a un User


    UserQueryRequest mapUserQueryModelToUserQueryRequest (UserQuerysModel userQuerysModel); // Mapea un objeto User a un UserRequest

    UserQueryResponse mapUserQueryModelToUserQueryResponse(UserQuerysModel user); // Mapea un objeto User a un UserResponse

    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "updatedAt", ignore = true)
    UserQueryEntity toUserEntity(User user); // Mapea un objeto User a un UserEntity

    UserQueryResponse mapUserQueryEntitytoUserQueryResponse(UserQueryEntity userQueryEntity); // Mapea un objeto UserEntity a un UserResponse

    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "updatedAt", ignore = true)
    UserQueryEntity toUserEntity(UserQueryResponse userQueryResponse); // Mapea un objeto UserResponse a un UserEntity

    List<UserQuerysModel> mapUserQueryEntityListToUserQueryModelList(List<UserQueryEntity> entity); // Mapea una lista de UserEntity a una lista de User

    List<UserQueryResponse> mapUserQueryModelListToUserQueryResponseList(List<UserQuerysModel> entity); // Mapea una lista de User a una lista de UserResponse

}
