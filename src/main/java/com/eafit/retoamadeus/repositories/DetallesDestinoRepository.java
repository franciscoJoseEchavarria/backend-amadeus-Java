package com.eafit.retoamadeus.repositories;


import com.eafit.retoamadeus.entities.DestinosEntity;
import com.eafit.retoamadeus.entities.DetallesDestinosEntity;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DetallesDestinoRepository extends JpaRepository<DetallesDestinosEntity,Long> {

    List<DetallesDestinosEntity> findByDestinosEntity_Id(Long destinoid);
    List<DetallesDestinosEntity> findByNombreDestino (String nombreDestino);

    @Query("SELECT d FROM DetalleDestinoEntity d " +
            "LEFT JOIN FETCH d.flightsEntityList " +
            "LEFT JOIN FETCH d.hotelsEntityList " +
            "WHERE d.nombreDestino = :nombreDestino")
    List<DetallesDestinosEntity> findByNombreDestinoWithJoins(@Param("nombreDestino") String nombreDestino);




}
