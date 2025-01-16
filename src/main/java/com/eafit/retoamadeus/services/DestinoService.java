package com.eafit.retoamadeus.services;

import com.eafit.retoamadeus.contracts.request.DestinosRequest;
import com.eafit.retoamadeus.contracts.responses.DestinosResponse;
import com.eafit.retoamadeus.entities.DestinosEntity;
import com.eafit.retoamadeus.entities.UserEntity;
import com.eafit.retoamadeus.entities.UserQueryEntity;
import com.eafit.retoamadeus.logic.Logica;
import com.eafit.retoamadeus.mappers.implementation.DestinoMapper;
import com.eafit.retoamadeus.models.User;
import com.eafit.retoamadeus.models.UserQuerysModel;
import com.eafit.retoamadeus.repositories.DestinoRepository;
import com.eafit.retoamadeus.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DestinoService {

    private final Logica logica;

    private final DestinoRepository destinoRepository;

    private final DestinoMapper destinoMapper;

    private final UserRepository userRepository;

    public DestinoService(Logica logica, DestinoRepository destinoRepository, DestinoMapper destinoMapper, UserRepository userRepository) {
        this.logica = logica;
        this.destinoRepository = destinoRepository;
        this.destinoMapper = destinoMapper;
        this.userRepository = userRepository;
    }

    @Transactional
    public DestinosResponse save (DestinosRequest destinosRequest) {
        if (destinosRequest.getUser() == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        UserEntity userEntity = userRepository.findById(destinosRequest.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        DestinosEntity destinosEntity = logica.logicaNegocio(destinosRequest);

        destinosEntity.setUserEntity(userEntity);

        destinosEntity = destinoRepository.save(destinosEntity);

        return destinoMapper.mapDestinosEntityToDestinoResponse(destinosEntity);



    }

    public List<DestinosResponse> findAll() {
        List<DestinosEntity> destinosEntities = destinoRepository.findAll();
        return destinosEntities.stream()
                .map(destinoMapper::mapDestinosEntityToDestinoResponse)
                .collect(Collectors.toList());
    }






}
