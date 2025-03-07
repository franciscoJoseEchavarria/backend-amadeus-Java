package com.eafit.retoamadeus.services;

import com.eafit.retoamadeus.entities.DestinosEntity;
import com.eafit.retoamadeus.entities.DetallesDestinosEntity;
import com.eafit.retoamadeus.entities.FlightsEntity;
import com.eafit.retoamadeus.entities.HotelsEntity;
import com.eafit.retoamadeus.logic.LogicFlights;
import com.eafit.retoamadeus.logic.LogicHotels;
import com.eafit.retoamadeus.mappers.implementation.DetallesdestinosMapper;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class DetailsVuelosAHotelsService {

    private final DetallesDestinoRepository detallesDestinoRepository;
    private final HotelsRepository hotelsRepository;
    private final FlightsRepository flightsRepository;
    private final DetailsVuelosAHotelsMapper detailsVuelosAHotelsMapper;
    private final LogicFlights logicFlights;
    private final LogicHotels logicHotels;
    private final FlightsMapper flightsMapper;
    private final HotelMapper hotelsMapper;
    private final DetallesdestinosMapper detallesdestinosMapper;


    /**
     * Obtiene los detalles de un destino
     * Aplica la respectiva lógica para obtener las recomendaciones de vuelos y hoteles
     * Este metodo se aplica en el controlador DestallesDestinos
     *
     * @param nombreDestino
     * @return
     */

    // se realiza como lista debido a que este metodo toma los dos resultados que se obtienen de la base de datos de nombreDestino
    public List<DetailsVuelosAHotelsModel> createDetailsForDestinity(String nombreDestino) { //recibe el parametro nombreDestino "cancun"

        List<DetallesDestinosEntity> detallesDestinosEntity = detallesDestinoRepository.findByNombreDestino(nombreDestino); //busca cancun en la db
        if (detallesDestinosEntity == null) {
            throw new RuntimeException("Destino no encontrado: " + nombreDestino);
        }
        // 1. Obtener los detalles de los destinosEntity a partir del nombre del destino a detailsVuelosAHotelsModels
        List <DetailsVuelosAHotelsModel> detailsVuelosAHotelsModels = detailsVuelosAHotelsMapper.mapDetallesDestinosEntitiesListToDetailsVuelosAHotelsModelsList(detallesDestinosEntity);

        // 2. details es una lista de detalles de destinosEntity que se obtiene de la base de datos
        // se iteran ya que tiene dos resultados
        for (int i = 0; i < detailsVuelosAHotelsModels.size(); i++) {
            DetailsVuelosAHotelsModel dto = detailsVuelosAHotelsModels.get(i);
            // Aquí se obtiene el contexto correcto para el DTO actual:
            DetallesDestinosEntity detalles = detallesDestinosEntity.get(i);

            //cada respuesta de Bobora, genera dos opciones de vuelos y hoteles
            List<FlightsModels> flightsDTOs = logicFlights.getFlightsRecomendation(dto.getNombreDestino());
            List<HotelModel> hotelsDTOs = logicHotels.getHotelRecommendations(dto.getNombreDestino());
            //tgransferimos de los modelos a las entidades
            List<FlightsEntity> flightsEntities = flightsMapper.mapFlightsModelsListToFlightsEntitiesList(flightsDTOs, detalles); //se utiliza el
            // detalle de DetallesDestinoEntity que es el padre de FlightsEntity y hotelsEntity para asignarle el detalle de destino
            List<HotelsEntity> hotelsEntities = hotelsMapper.mapHotelModelListToHotelsEntityList(hotelsDTOs, detalles);
            //guardamos en la base de datos

// Actualizar las colecciones de 'detalle'
            detalles.getFlightsEntityList().clear();
            detalles.getFlightsEntityList().addAll(flightsEntities);
            detalles.getHotelsEntityList().clear();
            detalles.getHotelsEntityList().addAll(hotelsEntities);

            // Persistir la entidad padre; con cascade se persisten también las colecciones
            DetallesDestinosEntity updatedDetalle = detallesDestinoRepository.save(detalles);

            detailsVuelosAHotelsMapper.mapDetallesDestinosEntityToDetailsVuelosAHotelModel(updatedDetalle);
        }

        // 4. Retornar la lista de DTOs
        //cambiar este metodo y controlador que esta en el controlador de detallesDestinos
        return detailsVuelosAHotelsModels;
    }


    /**
     * Lista los detalles de un destino a partir del nombre.
     * @param nombreDestino el nombre del destino.
     * @return Lista de DTOs con los detalles del destino.
     */
    public List<DetailsVuelosAHotelsModel> listDetailsForDestinity(String nombreDestino) {
        List<DetallesDestinosEntity> detallesList = detallesDestinoRepository.findByNombreDestino(nombreDestino);
        if (detallesList.isEmpty()) {
            throw new RuntimeException("Destino no encontrado: " + nombreDestino);
        }
        return detailsVuelosAHotelsMapper.mapDetallesDestinosEntitiesListToDetailsVuelosAHotelsModelsList(detallesList);
    }

}
