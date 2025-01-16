package com.eafit.retoamadeus.repositories;

import com.eafit.retoamadeus.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {


    // Buscar una persona por cédula


    // Guardar una persona
    UserEntity save(UserEntity userEntity);



    Optional<UserEntity> findByName(String name); // Encuentra un usuario por su nombre

    Optional<UserEntity> findByEmail(String email); // Encuentra un usuario por su correo electrónico

    Optional<UserEntity> findByNameAndEmail(String name, String email); // Encuentra un usuario por su nombre y correo electrónico

    boolean existsByEmail(String email); // Verifica si existe un usuario con un correo electrónico específic Se debe revisar este código


}