package com.eafit.retoamadeus.repositories;


import com.eafit.retoamadeus.entities.UserEntity;
import com.eafit.retoamadeus.entities.UserQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository //DAO, data access object

/**Un DAO (Data Access Object) es un patrón de diseño que proporciona una abstracción
 * para acceder a una fuente de datos, como una base de datos.
 * El propósito principal de un DAO es separar la lógica de acceso a datos de la lógica
 * de negocio, facilitando el mantenimiento y la escalabilidad del código. */

public interface UserQueryRepository extends JpaRepository<UserQueryEntity,Long> {

        //Buscar una persona por cédula
        Optional<UserQueryEntity>findById(Long id);

        //Guardar una persona
        UserQueryEntity save(UserQueryEntity userQueryEntity);


        // Buscar una entidad UserQueryEntity por el ID del usuario
        List<UserQueryEntity> findByUserEntityId(Long userId);

}
