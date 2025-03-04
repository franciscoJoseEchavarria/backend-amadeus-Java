package com.eafit.retoamadeus.services;

import com.eafit.retoamadeus.entities.DestinosEntity;
import com.eafit.retoamadeus.entities.DetallesDestinosEntity;
import com.eafit.retoamadeus.logic.LogicFlights;
import com.eafit.retoamadeus.logic.LogicHotels;
import com.eafit.retoamadeus.models.DetailsVuelosAHotelsModel;
import com.eafit.retoamadeus.models.DetallesDestinosModel;
import com.eafit.retoamadeus.models.FlightsModels;
import com.eafit.retoamadeus.models.HotelModel;
import com.eafit.retoamadeus.repositories.DetallesDestinoRepository;
import lombok.RequiredArgsConstructor;
import com.eafit.retoamadeus.mappers.implementation.DetailsVuelosAHotelsMapper;
import com.eafit.retoamadeus.repositories.DestinoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DetailsVuelosAHotelsService {

    private final DetallesDestinoRepository detallesDestinoRepository;

    private final DetailsVuelosAHotelsMapper detailsVuelosAHotelsMapper;
    private final LogicFlights logicFlights;
    private final LogicHotels logicHotels;

    /**
     * Obtiene los detalles de un destino
     * Aplica la respectiva lógica para obtener las recomendaciones de vuelos y hoteles
     * Este metodo se aplica en el controlador DestallesDestinos
     * @param nombreDestino
     * @return
     */

    public DetailsVuelosAHotelsModel getDetailsForDestinity (String nombreDestino) { //recibe el parametro nombreDestino "cancun"

        //1. Busca la entidad en la BD
        Optional <DetallesDestinosEntity> detallesDestinosEntity = detallesDestinoRepository.findByNombreDestino(nombreDestino); //busca cancun en la db
        if (detallesDestinosEntity == null) {
            throw new RuntimeException("Destino no encontrado: " + nombreDestino);
        }

        //2. Mapea la entiddad al DTO

        DetailsVuelosAHotelsModel detailsVuelosAHotelsModel = detailsVuelosAHotelsMapper.mapDetallesDestinosEntityToDetailsVuelosAHotelModel(detallesDestinosEntity.get());

        //3. Aplica la lógica de negocio

        List<FlightsModels> flightsModelsList = logicFlights.getFlightsRecomendation(nombreDestino);
        List<HotelModel> HotelModelList = logicHotels.getHotelRecommendations(nombreDestino);

        //4 Agrega la información al DTO

        detailsVuelosAHotelsModel.setFlights(flightsModelsList);
        detailsVuelosAHotelsModel.setHotels(HotelModelList);

        //5. Retorna el DTO
        return detailsVuelosAHotelsModel;
    }
}
