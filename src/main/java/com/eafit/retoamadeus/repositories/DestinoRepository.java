package com.eafit.retoamadeus.repositories;

import com.eafit.retoamadeus.contracts.request.DestinosRequest;
import com.eafit.retoamadeus.contracts.responses.DestinosResponse;
import com.eafit.retoamadeus.entities.DestinosEntity;
import com.eafit.retoamadeus.entities.UserQueryEntity;
import com.eafit.retoamadeus.models.DestinosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface DestinoRepository extends JpaRepository<DestinosEntity,Long> {

    Optional<DestinosEntity> findByUserQueryEntity(UserQueryEntity userQueryEntity);


}
