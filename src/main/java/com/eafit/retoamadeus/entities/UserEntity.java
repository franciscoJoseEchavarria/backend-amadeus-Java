package com.eafit.retoamadeus.entities;

import com.eafit.retoamadeus.models.RoleUser;
import jakarta.persistence.*;
import lombok.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Esta clase representa la entidad de usuario en la base de datos.
 * Se utiliza para mapear los datos de la tabla "users" a un objeto Java.
 * 
 * @autor Francisco Echavarría
 * @version 1.0
 */

@Entity
@Table(name = "users") // Define la clase como una entidad JPA y la mapea a la tabla 'users'
@Data // Genera automáticamente los métodos getter, setter, equals, hashCode y toString
@NoArgsConstructor // Genera un constructor sin argumentos
@AllArgsConstructor // Genera un constructor con todos los argumentos
@Builder // Permite usar el patrón de diseño builder para crear instancias de la clase


public class UserEntity {

    @Id // Indica que este campo es la clave primaria de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // Indica que este campo no puede ser nulo en la base de datos
    private String name;

    @Column(nullable = false) // Indica que este campo no puede ser nulo en la base de datos
    private String email;

    @Column(nullable = false) // Indica que este campo no puede ser nulo en la base de datos
    private RoleUser role;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UserQueryEntity> userQueryEntity;
    ; // Campo que referencia a la entidad UserEntity

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DestinosEntity> destinosEntity;

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                // Excluir 'queries' para evitar recursión infinita
                '}';
    }
}

/**
 UserRepository y UserEntity tienen roles diferentes en la interacción con la base de datos:
 UserRepository: Es una interfaz que extiende JpaRepository y proporciona métodos para
 realizar operaciones CRUD (crear, leer, actualizar, eliminar) sobre
 la entidad UserEntity. UserRepository actúa como un intermediario
 entre la aplicación y la base de datos, permitiendo realizar
 consultas y manipulaciones de datos sin necesidad de escribir SQL
 manualmente.
 UserEntity: Es una clase que representa una tabla en la base de datos.
 Cada instancia de UserEntity corresponde a una fila en la tabla.
 Los campos de la clase UserEntity corresponden a las columnas de la
 tabla. Esta clase se utiliza para mapear los datos de la base de
 datos a objetos Java y viceversa.
 En resumen, UserEntity define la estructura de los datos que se
 almacenan en la base de datos, mientras que UserRepository
 proporciona los métodos para interactuar con esos datos.
 */
