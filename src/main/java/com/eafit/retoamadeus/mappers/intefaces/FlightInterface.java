package com.eafit.retoamadeus.mappers.intefaces;

import com.eafit.retoamadeus.contracts.responses.FlightResponse;
import com.eafit.retoamadeus.contracts.responses.HotelResponse;
import com.eafit.retoamadeus.models.FlightsModels;
import com.eafit.retoamadeus.models.HotelModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring") // Indica que esta interfaz es un mapper de MapStruct y que debe ser gestionado
public interface FlightInterface {


    @Mapping(target = "detallesDestinos", source = "detallesDestinos")
    FlightResponse mapFlightModelToFlightRespose(FlightsModels flightsModels);

    List<FlightResponse> mapFlightModelListToFlightResponseList(List<FlightsModels> flightsModelsList);

}
