package com.eafit.retoamadeus.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Hotels") // Define la clase como una entidad JPA y la mapea a la tabla 'userQuerysEntities'
@Data // Genera automáticamente los métodos getter, setter, equals, hashCode y toString
@NoArgsConstructor // Genera un constructor sin argumentos
@AllArgsConstructor // Genera un constructor con todos los argumentos
@Builder // Permite usar el patrón de diseño builder para crear instancias de la clase


public class HotelsEntity {

    @Id //indica el id de la tabla flights
    @Column(nullable = false) // Indica que este campo no puede ser nulo en la base de datos
    private Long id;
    @Column (nullable = false) // Indica que este campo no puede ser nulo en la base de datos
    private String name;
    @Column (nullable = false) // Indica que este campo no puede ser nulo en la base de datos
    private String description;
    @Column (nullable = false) // Indica que este campo no puede ser nulo en la base de datos
    private String img;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Hot-detallesDestinoId", nullable = false)
    private DetallesDestinosEntity detallesDestinosEntity;

}
