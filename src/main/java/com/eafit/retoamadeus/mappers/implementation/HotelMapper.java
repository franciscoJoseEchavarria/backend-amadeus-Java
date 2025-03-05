package com.eafit.retoamadeus.mappers.implementation;



import com.eafit.retoamadeus.entities.DetallesDestinosEntity;
import com.eafit.retoamadeus.entities.HotelsEntity;
import com.eafit.retoamadeus.models.HotelModel;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Mapper(componentModel = "spring")
public interface HotelMapper {

     @Mapping(target = "detallesDestinosEntity", expression = "java(detallesDestino)")
     HotelsEntity mapHotelModelToHotelEntity(HotelModel hotelModel, @Context DetallesDestinosEntity detallesDestino) ;

     HotelModel mapHotelEntityToHotelModel(HotelsEntity hotelsEntity) ;

     default List<HotelsEntity> mapHotelModelListToHotelsEntityList(List<HotelModel> hotelModelList,  @Context DetallesDestinosEntity detallesDestino) {
         if (hotelModelList == null) {
             return Collections.emptyList();
         }
         List<HotelsEntity> hotelsEntities = new ArrayList<>();
         for (HotelModel model : hotelModelList) {
             hotelsEntities.add(mapHotelModelToHotelEntity(model, detallesDestino));
         }
         return hotelsEntities;
     }

     default List<HotelModel> mapHotelsEntityListToHotelModelList(List<HotelsEntity> hotelsEntityList) {
         if (hotelsEntityList == null) {
             return Collections.emptyList();
         }
         List<HotelModel> hotelModels = new ArrayList<>();
         for (HotelsEntity entity : hotelsEntityList) {
             hotelModels.add(mapHotelEntityToHotelModel(entity));
         }
         return hotelModels;
     }


}
