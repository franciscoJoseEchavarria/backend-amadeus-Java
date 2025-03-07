package com.eafit.retoamadeus.mappers.implementation;

import com.eafit.retoamadeus.entities.DetallesDestinosEntity;
import com.eafit.retoamadeus.entities.HotelsEntity;
import com.eafit.retoamadeus.models.HotelModel;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface HotelMapper {

    @Mapping(target = "detallesDestinosEntity", expression = "java(detallesDestino)")
    HotelsEntity mapHotelModelToHotelEntity(HotelModel hotelModel, @Context DetallesDestinosEntity detallesDestino);

    HotelModel mapHotelEntityToHotelModel(HotelsEntity hotelsEntity);

    // Método por defecto para mapear una lista, utilizando el contexto
    default List<HotelsEntity> mapHotelModelListToHotelsEntityList(List<HotelModel> hotelModelList, @Context DetallesDestinosEntity detallesDestino) {
        if (hotelModelList == null) {
            return Collections.emptyList();
        }
        return hotelModelList.stream()
                .map(model -> mapHotelModelToHotelEntity(model, detallesDestino))
                .collect(Collectors.toList());
    }

    default List<HotelModel> mapHotelsEntityListToHotelModelList(List<HotelsEntity> hotelsEntityList) {
        if (hotelsEntityList == null) {
            return Collections.emptyList();
        }
        return hotelsEntityList.stream()
                .map(this::mapHotelEntityToHotelModel)
                .collect(Collectors.toList());
    }
}
