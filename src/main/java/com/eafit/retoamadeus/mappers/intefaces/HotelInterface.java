package com.eafit.retoamadeus.mappers.intefaces;


import com.eafit.retoamadeus.contracts.responses.HotelResponse;
import com.eafit.retoamadeus.models.HotelModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring") // Indica que esta interfaz es un mapper de MapStruct y que debe ser gestionado
public interface HotelInterface {


    @Mapping(target = "detallesDestinosResponse", source = "detallesDestinosModel")
    HotelResponse mapHotelModelToHotelResponse(HotelModel hotelModel);

    List<HotelResponse> mapHotelModelListToHotelResponseList(List<HotelModel> hotelModelList);
}
