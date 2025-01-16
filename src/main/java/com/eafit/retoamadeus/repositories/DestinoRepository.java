package com.eafit.retoamadeus.repositories;

import com.eafit.retoamadeus.entities.DestinosEntity;
import com.eafit.retoamadeus.entities.UserQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface DestinoRepository extends JpaRepository<DestinosEntity,Long> {


}
