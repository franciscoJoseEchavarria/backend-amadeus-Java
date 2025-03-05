package com.eafit.retoamadeus.services;

import com.eafit.retoamadeus.entities.DestinosEntity;
import com.eafit.retoamadeus.entities.DetallesDestinosEntity;
import com.eafit.retoamadeus.entities.FlightsEntity;
import com.eafit.retoamadeus.entities.HotelsEntity;
import com.eafit.retoamadeus.logic.LogicFlights;
import com.eafit.retoamadeus.logic.LogicHotels;
import com.eafit.retoamadeus.mappers.implementation.FlightsMapper;
import com.eafit.retoamadeus.mappers.implementation.HotelMapper;
import com.eafit.retoamadeus.models.DetailsVuelosAHotelsModel;
import com.eafit.retoamadeus.models.DetallesDestinosModel;
import com.eafit.retoamadeus.models.FlightsModels;
import com.eafit.retoamadeus.models.HotelModel;
import com.eafit.retoamadeus.repositories.DetallesDestinoRepository;
import com.eafit.retoamadeus.repositories.FlightsRepository;
import com.eafit.retoamadeus.repositories.HotelsRepository;
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
    private final HotelsRepository hotelsRepository;
    private final FlightsRepository flightsRepository;
    private final DetailsVuelosAHotelsMapper detailsVuelosAHotelsMapper;
    private final LogicFlights logicFlights;
    private final LogicHotels logicHotels;
    private final FlightsMapper flightsMapper;
    private final HotelMapper hotelsMapper;

    /**
     * Obtiene los detalles de un destino
     * Aplica la respectiva lógica para obtener las recomendaciones de vuelos y hoteles
     * Este metodo se aplica en el controlador DestallesDestinos
     *
     * @param nombreDestino
     * @return
     */

    // se realiza como lista debido a que este metodo toma los dos resultados que se obtienen de la base de datos de nombreDestino
    public List <DetailsVuelosAHotelsModel> getDetailsForDestinity(String nombreDestino) { //recibe el parametro nombreDestino "cancun"

        //1. Busca la entidad nombreDestino de DetallesDestinosEntity en la base de datos - se busca en la base de datos
        List<DetallesDestinosEntity> detallesDestinosEntity = detallesDestinoRepository.findByNombreDestino(nombreDestino); //busca cancun en la db
        if (detallesDestinosEntity == null) {
            throw new RuntimeException("Destino no encontrado: " + nombreDestino);
        }

        //2. Mapea la entiddad al DTO - al tener dos destino distinto que se crean en simultaneo, se realiza como lista
        // -borabora y dubai y se lo asigna a la clase DetailsVuelosAHotelsModel

        List<DetailsVuelosAHotelsModel> dtos = detailsVuelosAHotelsMapper.mapDetallesDestinosEntitiesListToDetailsVuelosAHotelsModelsList(detallesDestinosEntity);


        // cambiar este metodo como create, ya que se esta creando un nuevo registro en la base de datos
        //realizar otro metodo para listar los detalles de los destinos

        // 3. Para cada DTO, aplicar la lógica de negocio. Como hay dos datos diferente, se crea un for para recorrer la lista "dubai y Borabora"
        for (int i = 0; i < dtos.size(); i++) {
            DetailsVuelosAHotelsModel dto = dtos.get(i);
            // Obtén la entidad DetallesDestinosEntity correspondiente (por ejemplo, la misma por índice)
            DetallesDestinosEntity detalle = detallesDestinosEntity.get(i); //se obtiene el detalle de la
            // lista de detalles para cada destino, esto se realiza para le contexto de cada destino

            //cada respuesta de Bobora, genera dos opciones de vuelos y hoteles
            List<FlightsModels> flightsDTOs = logicFlights.getFlightsRecomendation(dto.getNombreDestino());
            List<HotelModel> hotelsDTOs = logicHotels.getHotelRecommendations(dto.getNombreDestino());
            //tgransferimos de los modelos a las entidades
            List<FlightsEntity> flightsEntities = flightsMapper.mapFlightsModelsListToFlightsEntitiesList(flightsDTOs, detalle); //se utiliza el
            // detalle de DetallesDestinoEntity que es el padre de FlightsEntity y hotelsEntity para asignarle el detalle de destino
            List<HotelsEntity> hotelsEntities = hotelsMapper.mapHotelModelListToHotelsEntityList(hotelsDTOs, detalle);
            //guardamos en la base de datos
            flightsRepository.saveAll(flightsEntities);
            hotelsRepository.saveAll(hotelsEntities);
            //actualizamos los datos de entidades a modelos
            List<FlightsModels> updatedFlightsDTOs = flightsMapper.mapFlightsEntitiesListToFlightsModelsList(flightsEntities);
            List<HotelModel> updatedHotelsDTOs = hotelsMapper.mapHotelsEntityListToHotelModelList(hotelsEntities);
            //actualizamos los datos de los modelos
            dto.setFlights(updatedFlightsDTOs);
            dto.setHotels(updatedHotelsDTOs);
        }

        // 4. Retornar la lista de DTOs
        //cambiar este metodo y controlador que esta en el controlador de detallesDestinos
        return dtos;
    }
}
