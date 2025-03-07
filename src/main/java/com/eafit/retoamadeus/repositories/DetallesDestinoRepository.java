package com.eafit.retoamadeus.repositories;


import com.eafit.retoamadeus.entities.DestinosEntity;
import com.eafit.retoamadeus.entities.DetallesDestinosEntity;
import com.eafit.retoamadeus.models.DestinosModel;
import com.eafit.retoamadeus.models.DetallesDestinosModel;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DetallesDestinoRepository extends JpaRepository<DetallesDestinosEntity,Long> {

    // Método para buscar por id de DestinosEntity
    List<DetallesDestinosEntity> findByDestinosEntity_Id(Long destinoid);
    // metodo para buscar por nombreDestino
    List<DetallesDestinosEntity> findByNombreDestino (String nombreDestino);
    // Método para buscar por nombreDestino y por el id de DestinosEntity
    DetallesDestinosEntity findByNombreDestinoAndDestinosEntity_Id(String nombreDestino, Long destinoId);


}
