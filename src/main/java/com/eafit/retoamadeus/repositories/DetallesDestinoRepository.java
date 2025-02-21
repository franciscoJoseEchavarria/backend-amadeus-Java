package com.eafit.retoamadeus.repositories;


import com.eafit.retoamadeus.entities.DetallesDestinosEntity;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetallesDestinoRepository extends JpaRepository<DetallesDestinosEntity,Long> {

    List<DetallesDestinosEntity> findByDestinosEntity_Id(Long destinoid);


}
