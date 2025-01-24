package com.eafit.retoamadeus.services;

import com.eafit.retoamadeus.contracts.request.DestinosRequest;
import com.eafit.retoamadeus.contracts.responses.DestinosResponse;
import com.eafit.retoamadeus.entities.DestinosEntity;
import com.eafit.retoamadeus.entities.UserEntity;
import com.eafit.retoamadeus.entities.UserQueryEntity;
import com.eafit.retoamadeus.logic.Logica;
import com.eafit.retoamadeus.mappers.implementation.DestinoMapper;
import com.eafit.retoamadeus.models.DestinosModel;
import com.eafit.retoamadeus.models.User;
import com.eafit.retoamadeus.models.UserQuerysModel;
import com.eafit.retoamadeus.repositories.DestinoRepository;
import com.eafit.retoamadeus.repositories.UserQueryRepository;
import com.eafit.retoamadeus.repositories.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DestinoService {

    private final Logica logica;

    private final DestinoRepository destinoRepository;

    private final DestinoMapper destinoMapper;

    private final UserRepository userRepository;

    private final UserQueryRepository userQueryRepository;

    public DestinoService(Logica logica, DestinoRepository destinoRepository,
                          DestinoMapper destinoMapper, UserRepository userRepository, UserQueryRepository userQueryRepository) {
        this.logica = logica;
        this.destinoRepository = destinoRepository;
        this.destinoMapper = destinoMapper;
        this.userRepository = userRepository;
        this.userQueryRepository = userQueryRepository;
    }


    public DestinosModel crearDestino (DestinosRequest destinosRequest) {


        UserEntity userEntity = userRepository.findById(destinosRequest.getUser().getId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        UserQueryEntity userQueryEntity = userQueryRepository.findById(destinosRequest.getUserQuerysModel().getId())
                .orElseThrow(() -> new RuntimeException("Consulta de usuario no encontrada"));

        DestinosModel destinosModel = logica.logicaNegocio(destinosRequest);

             // Busca si ya existe un destino asociado con la consulta del usuario
        Optional<DestinosEntity> existingDestino = destinoRepository.findByUserQueryEntity(userQueryEntity);

        // Declara una variable para almacenar la entidad de destino
        DestinosEntity destinosEntity;



        // Si existe un destino, lo obtiene
        if (existingDestino.isPresent()) {
            destinosEntity = existingDestino.get();
        } else {
            // Si no existe, crea una nueva entidad de destino
            destinosEntity = new DestinosEntity();
        }

        destinosEntity.setDestinoEuropa(destinosModel.getDestinoEuropa());
        destinosEntity.setDestinoAmerica(destinosModel.getDestinoAmerica());
        destinosEntity.setUserEntity(userEntity);
        destinosEntity.setUserQueryEntity(userQueryEntity);

        destinosEntity = destinoRepository.save(destinosEntity);

        return destinoMapper .mapDestinoEntitiesDestinoModel(destinosEntity);

    }


    public DestinosModel obtenerDestinoId(Long id) {
        DestinosEntity destinosEntity = destinoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Destino no encontrado"));

        return destinoMapper.mapDestinoEntitiesDestinoModel(destinosEntity);
    }


        public List<DestinosModel> findAll() {
            return destinoRepository.findAll().stream()
                    .map(destinoMapper::mapDestinoEntitiesDestinoModel)
                    .collect(Collectors.toList());
        }

}
