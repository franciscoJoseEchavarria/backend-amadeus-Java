package com.eafit.retoamadeus.mappers.implementation;
import com.eafit.retoamadeus.entities.DetallesDestinosEntity;
import com.eafit.retoamadeus.entities.FlightsEntity;
import com.eafit.retoamadeus.models.FlightsModels;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Mapper(componentModel = "spring")
public interface FlightsMapper {

    @Mapping(target = "detallesDestinosEntity", expression = "java(detallesDestino)")
    FlightsEntity mapFlightsModelToFlightsEntity(FlightsModels flightsModels, @Context DetallesDestinosEntity detallesDestino) ;

    FlightsModels mapFlightsEntityToFlightsModel(FlightsEntity flightsEntity) ;

    default List<FlightsEntity> mapFlightsModelsListToFlightsEntitiesList(List<FlightsModels> flightsModelsList, @Context DetallesDestinosEntity detallesDestino) {
        if (flightsModelsList == null) {
            return Collections.emptyList();
        }
        List<FlightsEntity> flightsEntities = new ArrayList<>();
        for (FlightsModels model : flightsModelsList) {
            flightsEntities.add(mapFlightsModelToFlightsEntity(model, detallesDestino));
        }
        return flightsEntities;
    }

    default List<FlightsModels> mapFlightsEntitiesListToFlightsModelsList(List<FlightsEntity> flightsEntityList) {
        if (flightsEntityList == null) {
            return Collections.emptyList();
        }
        List<FlightsModels> flightsModels = new ArrayList<>();
        for (FlightsEntity entity : flightsEntityList) {
            flightsModels.add(mapFlightsEntityToFlightsModel(entity));
        }
        return flightsModels;
    }


}
