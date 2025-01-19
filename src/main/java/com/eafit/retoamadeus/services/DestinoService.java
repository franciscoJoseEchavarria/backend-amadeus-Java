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

    private final UserQueryRepository userQueryRepository;

    public DestinoService(Logica logica, DestinoRepository destinoRepository,
                          DestinoMapper destinoMapper, UserRepository userRepository, UserQueryRepository userQueryRepository) {
        this.logica = logica;
        this.destinoRepository = destinoRepository;
        this.destinoMapper = destinoMapper;
        this.userRepository = userRepository;
        this.userQueryRepository = userQueryRepository;
    }

        @Transactional
        public DestinosModel save(DestinosModel destinosModel) {

            if (destinosModel == null) {
                throw new IllegalArgumentException("DestinosModel cannot be null");
            }

            if (destinosModel.getUser() == null) {
                throw new IllegalArgumentException("user no se esta guardando y da nulo");
            }

            UserEntity userEntity = userRepository.findById(destinosModel.getUser().getId())
                    .orElseThrow(() -> new RuntimeException("User not found"));

            if (destinosModel.getUserQuerysModel() == null || destinosModel.getUserQuerysModel().getId() == null) {
                throw new IllegalArgumentException("UserQuery cannot be null and must have an ID");
            }



            DestinosEntity destinosEntity = destinoMapper.mapDestinoModelToDestinoEntity(destinosModel);

               destinosEntity.setUserEntity(userEntity);


               UserQueryEntity userQueryEntity = userQueryRepository.findById(destinosModel.getUserQuerysModel().getId())
                       .orElseThrow(() -> new RuntimeException("UserQuery not found"));

                destinosEntity.setUserQueryEntity(userQueryEntity);

                destinosEntity = destinoRepository.save(destinosEntity);

            return destinoMapper.mapDestinoEntitiesDestinoModel(destinosEntity);
        }

        public List<DestinosModel> findAll() {
            return destinoRepository.findAll().stream()
                    .map(destinoMapper::mapDestinoEntitiesDestinoModel)
                    .collect(Collectors.toList());
        }

}
