package com.eafit.retoamadeus.services;

import com.eafit.retoamadeus.entities.DetallesDestinosEntity;
import com.eafit.retoamadeus.entities.HotelsEntity;
import com.eafit.retoamadeus.logic.LogicHotels;
import com.eafit.retoamadeus.mappers.implementation.DetallesdestinosMapper;
import com.eafit.retoamadeus.mappers.implementation.HotelMapper;
import com.eafit.retoamadeus.models.DestinosModel;
import com.eafit.retoamadeus.models.DetallesDestinosModel;
import com.eafit.retoamadeus.models.HotelModel;
import com.eafit.retoamadeus.repositories.DetallesDestinoRepository;
import com.eafit.retoamadeus.repositories.HotelsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service

public class HotelService {

    private final HotelMapper hotelMapper;
    private final HotelsRepository hotelsRepository;
    private final DetallesDestinoRepository detallesDestinoRepository;
    private final DetallesdestinosMapper detallesdestinosMapper;
    private final LogicHotels logicHotels;



    //toma el nombre Destino de la clase DestallesdestinoEntity y el Id de la clase DestinosEntity

    public List <HotelModel> createHotel(String nombreDestino, Long destinoId) {
        Optional<DetallesDestinosEntity> detallesDestinosEntity = Optional.ofNullable(detallesDestinoRepository.findByNombreDestinoAndDestinosEntity_Id(nombreDestino, destinoId));
        if (detallesDestinosEntity.isEmpty()) {
            throw new RuntimeException("Detalles de destino no encontrados");
        }
        DetallesDestinosModel detallesDestinosModel = detallesdestinosMapper.mapDetallesDestinoEntityToDetallesDestinoModel(detallesDestinosEntity.get());
        List<HotelModel> hotelModels =  logicHotels.getHotelRecommendations(detallesDestinosModel.getNombreDestino());
        //pasa el contexto a las entidades.
        List <HotelsEntity> hotelsEntities = hotelMapper.mapHotelModelListToHotelsEntityList(hotelModels, detallesDestinosEntity.get());
        hotelsRepository.saveAll(hotelsEntities);
        return hotelMapper.mapHotelsEntityListToHotelModelList(hotelsEntities);
    }

    public List<HotelModel> getHotelList (){
        List<HotelsEntity> hotelsEntities = hotelsRepository.findAll();
        return hotelMapper.mapHotelsEntityListToHotelModelList(hotelsEntities);
    }
}
