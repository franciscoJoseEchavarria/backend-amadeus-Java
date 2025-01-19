package com.eafit.retoamadeus.mappers.implementation;

import com.eafit.retoamadeus.contracts.request.UserQueryRequest;
import com.eafit.retoamadeus.contracts.request.UserRequest;
import com.eafit.retoamadeus.contracts.responses.UserResponse;
import com.eafit.retoamadeus.entities.DestinosEntity;
import com.eafit.retoamadeus.entities.UserEntity;
import com.eafit.retoamadeus.entities.UserQueryEntity;
import com.eafit.retoamadeus.models.DestinosModel;
import com.eafit.retoamadeus.models.User;
import com.eafit.retoamadeus.models.UserQuerysModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;



@Component
public class UserQueryMapper {

    // Mapea una lista de entidades UserQueryEntity a una lista de modelos UserQuerysModel
    public List<UserQuerysModel> mapUserQueryEntityListToUserQueryModelList(List<UserQueryEntity> entities) {
        return entities.stream() // Inicia un flujo de las entidades
                .map(this::mapUserQueryEntityToUserQueryModel) // Mapea cada entidad a un modelo
                .collect(Collectors.toList()); // Recoge los resultados en una lista
    }

    // Mapea un modelo UserQuerysModel a una entidad UserQueryEntity
    public UserQueryEntity mapUserQueryModelToUserQueryEntity(UserQuerysModel userQuerysModel) {
        return UserQueryEntity.builder() // Inicia el patrón builder para UserQueryEntity
                .id(userQuerysModel.getId()) // Asigna el ID del modelo a la entidad
                .query(userQuerysModel.getQuery()) // Asigna la consulta del modelo a la entidad
                .queryTime(userQuerysModel.getQueryTime()) // Asigna el tiempo de consulta del modelo a la entidad
                .environmentType1(userQuerysModel.getEnvironmentType1()) // Asigna el tipo de ambiente 1 del modelo a la entidad
                .climateType2(userQuerysModel.getClimateType2()) // Asigna el tipo de clima 2 del modelo a la entidad
                .accommodationType3(userQuerysModel.getAccommodationType3()) // Asigna el tipo de alojamiento 3 del modelo a la entidad
                .activityType4(userQuerysModel.getActivityType4()) // Asigna el tipo de actividad 4 del modelo a la entidad
                .stayDuration(userQuerysModel.getStayDuration()) // Asigna la duración de la estancia del modelo a la entidad
                .ageRange(userQuerysModel.getAgeRange()) // Asigna el rango de edad del modelo a la entidad
                .userEntity(userQuerysModel.getUser() != null ? // Si el usuario no es nulo
                        UserEntity.builder()
                                .id(userQuerysModel.getUser().getId())
                                .name(userQuerysModel.getUser().getName())
                                .email(userQuerysModel.getUser().getEmail())
                                .role(userQuerysModel.getUser().getRole())
                                .build() : null)
                .destinosEntity(userQuerysModel.getDestinosModel() != null ? // Si los destinos no son nulos
                        DestinosEntity.builder()
                                .id(userQuerysModel.getDestinosModel().getId())
                                .destinoAmerica(userQuerysModel.getDestinosModel().getDestinoAmerica())
                                .destinoEuropa(userQuerysModel.getDestinosModel().getDestinoEuropa())
                                .build() : null)

                .build(); // Construye la entidad UserQueryEntity
    }

    // Mapea una entidad UserQueryEntity a un modelo UserQuerysModel
    public UserQuerysModel mapUserQueryEntityToUserQueryModel(UserQueryEntity userQueryEntity) {
        return UserQuerysModel.builder() // Inicia el patrón builder para UserQuerysModel
                .id(userQueryEntity.getId()) // Asigna el ID de la entidad al modelo
                .query(userQueryEntity.getQuery()) // Asigna la consulta de la entidad al modelo
                .queryTime(userQueryEntity.getQueryTime()) // Asigna el tiempo de consulta de la entidad al modelo
                .environmentType1(userQueryEntity.getEnvironmentType1()) // Asigna el tipo de ambiente 1 de la entidad al modelo
                .climateType2(userQueryEntity.getClimateType2()) // Asigna el tipo de clima 2 de la entidad al modelo
                .accommodationType3(userQueryEntity.getAccommodationType3()) // Asigna el tipo de alojamiento 3 de la entidad al modelo
                .activityType4(userQueryEntity.getActivityType4()) // Asigna el tipo de actividad 4 de la entidad al modelo
                .stayDuration(userQueryEntity.getStayDuration()) // Asigna la duración de la estancia de la entidad al modelo
                .ageRange(userQueryEntity.getAgeRange()) // Asigna el rango de edad de la entidad al modelo
                .user(userQueryEntity.getUserEntity() != null ? // Si la entidad de usuario no es nula
                        User.builder()
                                .id(userQueryEntity.getUserEntity().getId())
                                .name(userQueryEntity.getUserEntity().getName())
                                .email(userQueryEntity.getUserEntity().getEmail())
                                .role(userQueryEntity.getUserEntity().getRole())
                                .build() : null)
                .destinosModel(userQueryEntity.getDestinosEntity() != null ? // Si la entidad de destinos no es nula
                        DestinosModel.builder()
                                .id(userQueryEntity.getDestinosEntity().getId())
                                .destinoAmerica(userQueryEntity.getDestinosEntity().getDestinoAmerica())
                                .destinoEuropa(userQueryEntity.getDestinosEntity().getDestinoEuropa())
                                .build() : null)
                .build(); // Construye el modelo UserQuerysModel
    }

    // MAS ADELANTE, AVERIGUAR ESTO DONDE SE UTILIZARÍA. NO SE USA EN NINGÚN LADO

    public UserQuerysModel mapUserQueryRequestToUserQueryModel(UserQueryRequest userQueryRequest) {
        return UserQuerysModel.builder()

                .environmentType1(userQueryRequest.getEnvironmentType1())
                .climateType2(userQueryRequest.getClimateType2())
                .accommodationType3(userQueryRequest.getAccommodationType3())
                .activityType4(userQueryRequest.getActivityType4())
                .stayDuration(userQueryRequest.getStayDuration())
                .ageRange(userQueryRequest.getAgeRange())

                .build();
    }
}



