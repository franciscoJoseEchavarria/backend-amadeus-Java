package com.eafit.retoamadeus.mappers.implementation;

import com.eafit.retoamadeus.entities.DestinosEntity;
import com.eafit.retoamadeus.entities.DetallesDestinosEntity;
import com.eafit.retoamadeus.entities.UserEntity;
import com.eafit.retoamadeus.entities.UserQueryEntity;
import com.eafit.retoamadeus.models.DestinosModel;
import com.eafit.retoamadeus.models.DetallesDestinosModel;
import com.eafit.retoamadeus.models.User;
import com.eafit.retoamadeus.models.UserQuerysModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DetallesdestinosMapper {


    List<DetallesDestinosModel> mapDetallesDestinosEntityListToDetallesDestinosModelList(List<DetallesDestinosEntity> entities) {
        return entities.stream()
                .map(this::mapDetallesDestinoEntityToDetallesDestinoModel)
                .collect(Collectors.toList());
    }

    List<DetallesDestinosEntity> mapDetallesDestinosModelListToDetallesDestinosEntityList(List<DetallesDestinosModel> models) {
        return models.stream()
                .map(this::mapDetallesDestinosModelToDestallesDestinosEntity)
                .collect(Collectors.toList());
    }


    public DetallesDestinosEntity mapDetallesDestinosModelToDestallesDestinosEntity(DetallesDestinosModel detallesDestinosModel) {
        return DetallesDestinosEntity.builder()
                .id(detallesDestinosModel.getId())
                .nombreDestino(detallesDestinosModel.getNombreDestino())
                .img(detallesDestinosModel.getImg())
                .pais(detallesDestinosModel.getPais())
                .idioma(detallesDestinosModel.getIdioma())
                .lugarImperdible(detallesDestinosModel.getLugarImperdible())
                // Corrección del operador ternario y eliminación del punto extra
                .destinosEntity(detallesDestinosModel.getDestinosModel() != null ?
                        DestinosEntity.builder()
                                .id(detallesDestinosModel.getDestinosModel().getId())
                                .destinoAmerica(detallesDestinosModel.getDestinosModel().getDestinoAmerica())
                                .destinoEuropa(detallesDestinosModel.getDestinosModel().getDestinoEuropa())
                                // Corrección del operador ternario y eliminación del punto extra
                                .userEntity(detallesDestinosModel.getDestinosModel().getUser() != null ?
                                        UserEntity.builder()
                                                .id(detallesDestinosModel.getDestinosModel().getUser().getId())
                                                .name(detallesDestinosModel.getDestinosModel().getUser().getName())
                                                .email(detallesDestinosModel.getDestinosModel().getUser().getEmail())
                                                .role(detallesDestinosModel.getDestinosModel().getUser().getRole())
                                                .build() : null)
                                // Corrección del operador ternario y eliminación del punto extra
                                .userQueryEntity(detallesDestinosModel.getDestinosModel().getUserQuerysModel() != null ?
                                        UserQueryEntity.builder()
                                                .id(detallesDestinosModel.getDestinosModel().getUserQuerysModel().getId())
                                                .query(detallesDestinosModel.getDestinosModel().getUserQuerysModel().getQuery())
                                                .queryTime(detallesDestinosModel.getDestinosModel().getUserQuerysModel().getQueryTime())
                                                .environmentType1(detallesDestinosModel.getDestinosModel().getUserQuerysModel().getEnvironmentType1())
                                                .climateType2(detallesDestinosModel.getDestinosModel().getUserQuerysModel().getClimateType2())
                                                .accommodationType3(detallesDestinosModel.getDestinosModel().getUserQuerysModel().getAccommodationType3())
                                                .activityType4(detallesDestinosModel.getDestinosModel().getUserQuerysModel().getActivityType4())
                                                .stayDuration(detallesDestinosModel.getDestinosModel().getUserQuerysModel().getStayDuration())
                                                .ageRange(detallesDestinosModel.getDestinosModel().getUserQuerysModel().getAgeRange())
                                                .build() : null)
                                .build() : null)
                .build();
    }


    public DetallesDestinosModel mapDetallesDestinoEntityToDetallesDestinoModel(DetallesDestinosEntity detallesDestinosEntity) {
        return DetallesDestinosModel.builder()
                .id(detallesDestinosEntity.getId())
                .nombreDestino(detallesDestinosEntity.getNombreDestino())
                .img(detallesDestinosEntity.getImg())
                .pais(detallesDestinosEntity.getPais())
                .idioma(detallesDestinosEntity.getIdioma())
                .lugarImperdible(detallesDestinosEntity.getLugarImperdible())
                .destinosModel(detallesDestinosEntity.getDestinosEntity() != null ?
                        DestinosModel.builder()
                                .id(detallesDestinosEntity.getDestinosEntity().getId())
                                .destinoAmerica(detallesDestinosEntity.getDestinosEntity().getDestinoAmerica())
                                .destinoEuropa(detallesDestinosEntity.getDestinosEntity().getDestinoEuropa())
                                .user(detallesDestinosEntity.getDestinosEntity().getUserEntity() != null ?
                                        User.builder()
                                                .id(detallesDestinosEntity.getDestinosEntity().getUserEntity().getId())
                                                .name(detallesDestinosEntity.getDestinosEntity().getUserEntity().getName())
                                                .email(detallesDestinosEntity.getDestinosEntity().getUserEntity().getEmail())
                                                .role(detallesDestinosEntity.getDestinosEntity().getUserEntity().getRole())
                                                .build() : null)
                                .userQuerysModel(detallesDestinosEntity.getDestinosEntity().getUserQueryEntity() != null ?
                                        UserQuerysModel.builder()
                                                .id(detallesDestinosEntity.getDestinosEntity().getUserQueryEntity().getId())
                                                .query(detallesDestinosEntity.getDestinosEntity().getUserQueryEntity().getQuery())
                                                .queryTime(detallesDestinosEntity.getDestinosEntity().getUserQueryEntity().getQueryTime())
                                                .environmentType1(detallesDestinosEntity.getDestinosEntity().getUserQueryEntity().getEnvironmentType1())
                                                .climateType2(detallesDestinosEntity.getDestinosEntity().getUserQueryEntity().getClimateType2())
                                                .accommodationType3(detallesDestinosEntity.getDestinosEntity().getUserQueryEntity().getAccommodationType3())
                                                .activityType4(detallesDestinosEntity.getDestinosEntity().getUserQueryEntity().getActivityType4())
                                                .stayDuration(detallesDestinosEntity.getDestinosEntity().getUserQueryEntity().getStayDuration())
                                                .ageRange(detallesDestinosEntity.getDestinosEntity().getUserQueryEntity().getAgeRange())
                                                .build() : null)
                                .build() : null)
                .build();


    }
}
/**
 *
 * package com.eafit.retoamadeus.mappers.implementation;

import com.eafit.retoamadeus.entities.DestinosEntity;
import com.eafit.retoamadeus.entities.DetallesDestinosEntity;
import com.eafit.retoamadeus.entities.UserEntity;
import com.eafit.retoamadeus.entities.UserQueryEntity;
import com.eafit.retoamadeus.models.DetallesDestinosModel;
import org.springframework.stereotype.Component;

@Component
public class DetallesdestinosMapper {

    public DetallesDestinosEntity mapDestinosModelToDestinosEntity(DetallesDestinosModel detallesDestinosModel) {
        return DetallesDestinosEntity.builder()
                .id(detallesDestinosModel.getId())
                .nombreDestino(detallesDestinosModel.getNombreDestino())
                .img(detallesDestinosModel.getImg())
                .pais(detallesDestinosModel.getPais())
                .idioma(detallesDestinosModel.getIdioma())
                .lugarImperdible(detallesDestinosModel.getLugarImperdible())
                .destinosEntity(detallesDestinosModel.getDestinosModel() != null ?
                        DestinosEntity.builder()
                                .id(detallesDestinosModel.getDestinosModel().getId())
                                .destinoAmerica(detallesDestinosModel.getDestinosModel().getDestinoAmerica())
                                .destinoEuropa(detallesDestinosModel.getDestinosModel().getDestinoEuropa())
                                .userEntity(detallesDestinosModel.getDestinosModel().getUser() != null ?
                                        UserEntity.builder()
                                                .id(detallesDestinosModel.getDestinosModel().getUser().getId())
                                                .name(detallesDestinosModel.getDestinosModel().getUser().getName())
                                                .email(detallesDestinosModel.getDestinosModel().getUser().getEmail())
                                                .role(detallesDestinosModel.getDestinosModel().getUser().getRole())
                                                .build() : null)
                                .userQueryEntity(detallesDestinosModel.getDestinosModel().getUserQuerysModel() != null ?
                                        UserQueryEntity.builder()
                                                .id(detallesDestinosModel.getDestinosModel().getUserQuerysModel().getId())
                                                .query(detallesDestinosModel.getDestinosModel().getUserQuerysModel().getQuery())
                                                .queryTime(detallesDestinosModel.getDestinosModel().getUserQuerysModel().getQueryTime())
                                                .environmentType1(detallesDestinosModel.getDestinosModel().getUserQuerysModel().getEnvironmentType1())
                                                .climateType2(detallesDestinosModel.getDestinosModel().getUserQuerysModel().getClimateType2())
                                                .accommodationType3(detallesDestinosModel.getDestinosModel().getUserQuerysModel().getAccommodationType3())
                                                .activityType4(detallesDestinosModel.getDestinosModel().getUserQuerysModel().getActivityType4())
                                                .stayDuration(detallesDestinosModel.getDestinosModel().getUserQuerysModel().getStayDuration())
                                                .ageRange(detallesDestinosModel.getDestinosModel().getUserQuerysModel().getAgeRange())
                                                .build() : null)
                                .build() : null)
                .build();
    }
}
 */