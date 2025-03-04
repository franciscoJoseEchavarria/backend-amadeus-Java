package com.eafit.retoamadeus.mappers.implementation;


import com.eafit.retoamadeus.entities.FlightsEntity;
import com.eafit.retoamadeus.models.FlightsModels;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FlightsMapper {

    public FlightsEntity mapFlightsModelToFlightsEntity(FlightsModels flightsModels) ;

    public FlightsModels mapFlightsEntityToFlightsModel(FlightsEntity flightsEntity) ;

}
