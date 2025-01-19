package com.eafit.retoamadeus.mappers.implementation;

// Importa las clases necesarias
import com.eafit.retoamadeus.contracts.request.DestinosRequest;
import com.eafit.retoamadeus.contracts.responses.DestinosResponse;
import com.eafit.retoamadeus.entities.DestinosEntity;
import com.eafit.retoamadeus.entities.UserEntity;
import com.eafit.retoamadeus.entities.UserQueryEntity;
import com.eafit.retoamadeus.mappers.intefaces.DestinoInterface;
import com.eafit.retoamadeus.models.DestinosModel;
import com.eafit.retoamadeus.models.User;
import com.eafit.retoamadeus.models.UserQuerysModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component // Anotación que indica que esta clase es un componente de Spring
public class DestinoMapper {



   public List <DestinosModel> mapDestinoEntityListToDestinoModelList (List <DestinosEntity> entities) {
        return   entities.stream() // Inicia un flujo de las entidades
                .map(this::mapDestinoEntitiesDestinoModel) // Mapea cada entidad a un modelo
                .collect(Collectors.toList()); // Recoge los resultados en una lista
        }

    public DestinosModel mapDestinoEntitiesDestinoModel(DestinosEntity destinosEntity) {
        return DestinosModel.builder() // Inicia el patrón builder para DestinosModel
                .id(destinosEntity.getId()) // Asigna el ID de la entidad al modelo
                .destinoAmerica(destinosEntity.getDestinoAmerica()) // Asigna el destino de América de la entidad al modelo
                .destinoEuropa(destinosEntity.getDestinoEuropa()) // Asigna el destino de Europa de la entidad al modelo
                .user(destinosEntity.getUserEntity() != null ? // Si el usuario no es nulo
                        User.builder()
                                .id(destinosEntity.getUserEntity().getId())
                                .name(destinosEntity.getUserEntity().getName())
                                .email(destinosEntity.getUserEntity().getEmail())
                                .role(destinosEntity.getUserEntity().getRole())
                                .build() : null)
                         // Construye el modelo DestinosModel

                .userQuerysModel (destinosEntity.getUserQueryEntity() != null ?
                        UserQuerysModel.builder()
                                .id(destinosEntity.getUserQueryEntity().getId())
                                .query(destinosEntity.getUserQueryEntity().getQuery())
                                .queryTime(destinosEntity.getUserQueryEntity().getQueryTime())
                                .environmentType1(destinosEntity.getUserQueryEntity().getEnvironmentType1())
                                .climateType2(destinosEntity.getUserQueryEntity().getClimateType2())
                                .accommodationType3(destinosEntity.getUserQueryEntity().getAccommodationType3())
                                .activityType4(destinosEntity.getUserQueryEntity().getActivityType4())
                                .stayDuration(destinosEntity.getUserQueryEntity().getStayDuration())
                                .ageRange(destinosEntity.getUserQueryEntity().getAgeRange())
                                .build() : null)

                .build();
    }



    public DestinosEntity mapDestinoModelToDestinoEntity(DestinosModel destinosModel) {
        return DestinosEntity.builder() // Inicia el patrón builder para DestinosEntity
                .id(destinosModel.getId()) // Asigna el ID del modelo a la entidad
                .destinoAmerica(destinosModel.getDestinoAmerica()) // Asigna el destino de América del modelo a la entidad
                .destinoEuropa(destinosModel.getDestinoEuropa()) // Asigna el destino de Europa del modelo a la entidad
                .userEntity(destinosModel.getUser() != null ? // Si el usuario no es nulo
                        UserEntity.builder()
                                .id(destinosModel.getUser().getId())
                                .name(destinosModel.getUser().getName())
                                .email(destinosModel.getUser().getEmail())
                                .role(destinosModel.getUser().getRole())
                                .build() : null)

                .userQueryEntity(destinosModel.getUserQuerysModel() != null ? // Si la consulta de usuario no es nula
                        UserQueryEntity.builder()
                                .id(destinosModel.getUserQuerysModel().getId())
                                .query(destinosModel.getUserQuerysModel().getQuery())
                                .queryTime(destinosModel.getUserQuerysModel().getQueryTime())
                                .environmentType1(destinosModel.getUserQuerysModel().getEnvironmentType1())
                                .climateType2(destinosModel.getUserQuerysModel().getClimateType2())
                                .accommodationType3(destinosModel.getUserQuerysModel().getAccommodationType3())
                                .activityType4(destinosModel.getUserQuerysModel().getActivityType4())
                                .stayDuration(destinosModel.getUserQuerysModel().getStayDuration())
                                .ageRange(destinosModel.getUserQuerysModel().getAgeRange())
                                .build() : null)
                .build(); // Construye la entidad DestinosEntity
    }
}



