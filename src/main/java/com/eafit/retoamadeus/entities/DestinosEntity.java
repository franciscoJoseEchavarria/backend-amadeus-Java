package com.eafit.retoamadeus.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "destinosEntity") // Define la clase como una entidad JPA y la mapea a la tabla 'userQuerysEntities'
@Data // Genera automáticamente los métodos getter, setter, equals, hashCode y toString
@NoArgsConstructor // Genera un constructor sin argumentos
@AllArgsConstructor // Genera un constructor con todos los argumentos
@Builder // Permite usar el patrón de diseño builder para crear instancias de la clase

public class DestinosEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String destinoAmerica;

    @Column(nullable = false)
    private String destinoEuropa;


    @ManyToOne ( cascade = CascadeType.ALL, fetch = FetchType.LAZY)// Indica una relación de muchos a uno con otra entidad
    @JoinColumn(name = "user_id", nullable = false) // Define la columna de unión para la relación y que no puede ser nula
    private UserEntity userEntity; // Campo que referencia a la entidad UserEntity


    @OneToOne ( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "userQuery_id", nullable = false)
    private UserQueryEntity userQueryEntity;

    @OneToMany  (mappedBy = "destinosEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List <DetallesDestinosEntity> detallesDestinoEntity;

    // se añade el constructor con los atributos de la clase



}
