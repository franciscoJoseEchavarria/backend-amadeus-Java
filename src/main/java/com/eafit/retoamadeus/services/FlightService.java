package com.eafit.retoamadeus.services;


import com.eafit.retoamadeus.entities.DetallesDestinosEntity;
import com.eafit.retoamadeus.entities.FlightsEntity;
import com.eafit.retoamadeus.logic.LogicFlights;
import com.eafit.retoamadeus.mappers.implementation.DetallesdestinosMapper;
import com.eafit.retoamadeus.mappers.implementation.FlightsMapper;
import com.eafit.retoamadeus.models.DetallesDestinosModel;
import com.eafit.retoamadeus.models.FlightsModels;
import com.eafit.retoamadeus.repositories.DestinoRepository;
import com.eafit.retoamadeus.repositories.DetallesDestinoRepository;
import com.eafit.retoamadeus.repositories.FlightsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class FlightService {

        private final FlightsRepository flightRepository;
        private final FlightsMapper flightMapper;
        private final DetallesDestinoRepository detallesDestinoRepository;
        private final DetallesdestinosMapper detallesdestinosMapper;
        private final LogicFlights logicFlights;




    public List<FlightsModels> createFlights (String nombreDestino, Long destinoId) {

        Optional<DetallesDestinosEntity> detallesDestinosEntity = Optional.ofNullable(detallesDestinoRepository.findByNombreDestinoAndDestinosEntity_Id(nombreDestino, destinoId));

        if (detallesDestinosEntity.isEmpty()) {
            throw new RuntimeException("Detalles de destino no encontrados");
        }

        DetallesDestinosModel detallesDestinosModel = detallesdestinosMapper.mapDetallesDestinoEntityToDetallesDestinoModel(detallesDestinosEntity.get());
        List<FlightsModels> flightsModelsList = flightMapper.mapFlightsEntitiesListToFlightsModelsList(flightRepository.
                saveAll(flightMapper.mapFlightsModelsListToFlightsEntitiesList(logicFlights.getFlightsRecomendation
                        (detallesDestinosModel.getNombreDestino()), detallesDestinosEntity.get())));
        return  flightsModelsList;
        }

        public List<FlightsModels> getFlightsList (){
            List<FlightsEntity> flightsEntities = flightRepository.findAll();
            return flightMapper.mapFlightsEntitiesListToFlightsModelsList(flightsEntities);
        }
}
