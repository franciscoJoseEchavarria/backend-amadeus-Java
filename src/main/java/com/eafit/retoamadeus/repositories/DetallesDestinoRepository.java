package com.eafit.retoamadeus.repositories;


import com.eafit.retoamadeus.entities.DestinosEntity;
import com.eafit.retoamadeus.entities.DetallesDestinosEntity;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DetallesDestinoRepository extends JpaRepository<DetallesDestinosEntity,Long> {

    List<DetallesDestinosEntity> findByDestinosEntity_Id(Long destinoid);
    Optional<DetallesDestinosEntity> findByNombreDestino (String nombreDestino);


}
