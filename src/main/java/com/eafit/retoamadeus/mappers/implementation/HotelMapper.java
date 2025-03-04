package com.eafit.retoamadeus.mappers.implementation;



import com.eafit.retoamadeus.entities.FlightsEntity;
import com.eafit.retoamadeus.entities.HotelsEntity;
import com.eafit.retoamadeus.models.FlightsModels;
import com.eafit.retoamadeus.models.HotelModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HotelMapper {

    public HotelsEntity mapHotelModelToHotelEntity(HotelModel hotelModel) ;

    public HotelModel mapHotelEntityToHotelModel(HotelsEntity hotelsEntity) ;


}
