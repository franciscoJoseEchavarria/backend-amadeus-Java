package com.eafit.retoamadeus.services;

import com.eafit.retoamadeus.entities.UserEntity;
import com.eafit.retoamadeus.exeption.user.InvalidUserDataException;

import com.eafit.retoamadeus.exeption.user.UserAlreadyExistsException;
import com.eafit.retoamadeus.mappers.implementation.UserMapper;
import com.eafit.retoamadeus.models.User;
import com.eafit.retoamadeus.repositories.UserRepository;
import lombok.*;

import java.util.List;

import org.mapstruct.control.MappingControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;


@Service

@Data
@Getter
@Setter
@Builder

public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    // Constructor para inyectar las dependencias del repositorio y el mapper

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    // Método para crear un nuevo usuario
    public User create (User user) {
        // Mapea el modelo User a la entidad UserEntity
        UserEntity userEntity = userMapper.mapUserModelToUserEntity(user);

        // Establece la fecha de creación y actualización del usuario
        userEntity.setCreatedAt(LocalDateTime.now());
        userEntity.setUpdatedAt(LocalDateTime.now());

        // Guarda la entidad UserEntity en el repositorio y mapea la entidad guardada de vuelta al modelo User
        User user1 = userMapper.mapUserEntityToUser(userRepository.save(userEntity));

        // Imprime un mensaje en la consola indicando que el usuario ha sido creado
        System.out.println("persona creada");

        // Retorna el usuario creado
        return user1;
    }

    // Devuelve una lista de objetos User obtenidos de la base de datos
    // Primero, obtiene todas las entidades UserEntity del repositorio
    // Luego, convierte cada UserEntity a un objeto User usando el método mapUserEntityToUser del userMapper
    // Finalmente, recoge los objetos User en una lista y la retorna

    public List<User> findAll() {
        return userRepository.findAll().stream()
                .map(userMapper::mapUserEntityToUser)
                .collect(Collectors.toList());
    }

    public User findByEmail(String email) {
        // Busca un UserEntity en el repositorio por el correo electrónico proporcionado
        Optional<UserEntity> UserEntityOptional = userRepository.findByEmail(email);

        // Verifica si el Optional está vacío, lo que significa que no se encontró un usuario con ese correo
        if (UserEntityOptional.isEmpty()) {
            // Imprime un mensaje en la consola indicando que no se encontró un usuario con el correo proporcionado
            System.out.println("El usuario con correo = " + email + " no existe");
        }

        // Mapea el UserEntity encontrado a un objeto User y lo retorna
        return userMapper.mapUserEntityToUser(UserEntityOptional.get());
    }

    public User findByName(String name){
        Optional<UserEntity> UserEntityOptional = userRepository.findByName(name);
        if (UserEntityOptional.isEmpty()) {
            System.out.println("El usuario con nombre = " + name + " no existe");
        }
        return userMapper.mapUserEntityToUser(UserEntityOptional.get());
    }

    public User findByNameAndEmail(String name, String email){
        Optional<UserEntity> UserEntityOptional = userRepository.findByNameAndEmail(name, email);
        if (UserEntityOptional.isEmpty()) {
            System.out.println("El usuario con nombre = " + name + " y correo = " + email + " no existe");
        }
        return userMapper.mapUserEntityToUser(UserEntityOptional.get());
    }

    public User deleteUser(Long id) {
    Optional<UserEntity> UserEntityOptional = userRepository.findById(id);
    if (UserEntityOptional.isEmpty()) {
        System.out.println("El usuario con id = " + id + " no existe");
        return null; // Retorna null si el usuario no existe
    }
    userRepository.deleteById(id);
    return userMapper.mapUserEntityToUser(UserEntityOptional.get());
    }

  public List<User> createMultipleUsers(List<User> users) {
    if (users == null || users.isEmpty()) {
        throw new InvalidUserDataException("User list cannot be null or empty");
    }
    List<UserEntity> userEntities = users.stream()
            .map(user -> {
                if (user.getName() == null || user.getEmail() == null) {
                    throw new InvalidUserDataException("Name, email, and birthdate are required for all users");
                }
                if (userRepository.existsByEmail(user.getEmail())) {
                    throw new UserAlreadyExistsException("User with email " + user.getEmail() + " already exists");
                }
                return userMapper.mapUserModelToUserEntity(user);
            })
            .collect(Collectors.toList());
    List<UserEntity> savedUserEntities = userRepository.saveAll(userEntities);
    return savedUserEntities.stream()
            .map(userMapper::mapUserEntityToUser)
            .collect(Collectors.toList());
    }


    public User findById(Long id) {
        // Busca un UserEntity en el repositorio por el ID proporcionado
        Optional<UserEntity> userEntityOptional = userRepository.findById(id);
        // Si se encuentra un UserEntity, lo mapea a un objeto User y lo retorna
        // Si no se encuentra, lanza una excepción InvalidUserDataException con un mensaje de error
        return userEntityOptional.map(userMapper::mapUserEntityToUser)
                .orElseThrow(() -> new InvalidUserDataException("User with id " + id + " not found"));
    }

}






