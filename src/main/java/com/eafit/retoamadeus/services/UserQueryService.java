package com.eafit.retoamadeus.services;

import com.eafit.retoamadeus.entities.UserEntity;
import com.eafit.retoamadeus.entities.UserQueryEntity;
import com.eafit.retoamadeus.mappers.implementation.UserQueryMapper;
import com.eafit.retoamadeus.models.UserQuerysModel;
import com.eafit.retoamadeus.repositories.UserQueryRepository;
import com.eafit.retoamadeus.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class UserQueryService {

    private final UserQueryRepository userQueryRepository;
    private final UserQueryMapper userQueryMapper;
    private final UserRepository userRepository;

    public UserQueryService(UserQueryRepository userQueryRepository, UserQueryMapper userQueryMapper, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.userQueryRepository = userQueryRepository;
        this.userQueryMapper = userQueryMapper;
    }

    /**
     * public UserQuerysModel save(UserQuerysModel userQuerysModel) {
     * UserQueryEntity userQueryEntity = userQueryMapper.mapUserQueryModelToUserQueryEntity(userQuerysModel);
     * UserQuerysModel userQueryModel1 = userQueryMapper.mapUserQueryEntityToUserQueryModel(userQueryRepository.save(userQueryEntity));
     * <p>
     * <p>
     * return userQueryModel1;
     * }
     */
    @Transactional
    public UserQuerysModel save(UserQuerysModel userQuerysModel) {
        // Verifica si el objeto User es nulo
        if (userQuerysModel.getUser() == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        // Busca la entidad de usuario correspondiente en el repositorio usando el ID del modelo de consulta de usuario
        UserEntity userEntity = userRepository.findById(userQuerysModel.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        // Convierte el modelo de consulta de usuario a una entidad de consulta de usuario
        UserQueryEntity userQuerysEntity = userQueryMapper.mapUserQueryModelToUserQueryEntity(userQuerysModel);


        // Asigna la entidad de usuario encontrada a la entidad de consulta de usuario
        userQuerysEntity.setUserEntity(userEntity);

        // Establece la fecha y hora actual como la fecha de creación de la entidad de consulta de usuario
        userQuerysEntity.setCreatedAt(LocalDateTime.now());

        // Establece la fecha y hora actual como la fecha de actualización de la entidad de consulta de usuario
        userQuerysEntity.setUpdatedAt(LocalDateTime.now());

        // Guarda la entidad de consulta de usuario en el repositorio y actualiza la referencia con la entidad guardada
        userQuerysEntity = userQueryRepository.save(userQuerysEntity);

        // Convierte la entidad de consulta de usuario guardada de nuevo a un modelo de consulta de usuario y lo retorna
        return userQueryMapper.mapUserQueryEntityToUserQueryModel(userQuerysEntity);
    }

    public UserQuerysModel findById(Long id) {
        // Busca una entidad de consulta de usuario en el repositorio por el ID proporcionado
        UserQueryEntity userQuerysEntity = userQueryRepository.findById(id).orElse(null);

        // Convierte la entidad de consulta de usuario encontrada a un modelo de consulta de usuario
        return userQueryMapper.mapUserQueryEntityToUserQueryModel(userQuerysEntity);
    }

    public List<UserQuerysModel> findAll() {
        // Busca todas las entidades de consulta de usuario en el repositorio
        List<UserQueryEntity> userQuerysEntities = userQueryRepository.findAll();

        // Convierte todas las entidades de consulta de usuario encontradas a una lista de modelos de consulta de usuario
        return userQueryMapper.mapUserQueryEntityListToUserQueryModelList(userQuerysEntities);
    }


}