package com.eafit.retoamadeus.entities; // Define el paquete al que pertenece esta clase

import com.eafit.retoamadeus.models.RoleUser; // Importa la clase RoleUser del paquete models
import com.eafit.retoamadeus.models.User; // Importa la clase User del paquete models
import jakarta.persistence.*; // Importa las anotaciones y clases de JPA para la persistencia de datos
import lombok.*; // Importa las anotaciones de Lombok para generar código automáticamente

import java.time.LocalDateTime; // Importa la clase LocalDateTime para manejar fechas y horas

@Entity(name = "userQuerysEntities") // Define la clase como una entidad JPA y la mapea a la tabla 'userQuerysEntities'
@Data // Genera automáticamente los métodos getter, setter, equals, hashCode y toString
@NoArgsConstructor // Genera un constructor sin argumentos
@AllArgsConstructor // Genera un constructor con todos los argumentos
@Builder // Permite usar el patrón de diseño builder para crear instancias de la clase

public class UserQueryEntity {

    @Id // Indica que este campo es la clave primaria de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera automáticamente un valor único para la clave primaria
    private Long id;

    @Column(nullable = false) // Indica que este campo no puede ser nulo en la base de datos
    private String query;

    @Column(nullable = false) // Indica que este campo no puede ser nulo en la base de datos
    private String queryTime;

    @Column(nullable = false) // Indica que este campo no puede ser nulo en la base de datos
    private String environmentType1;

    @Column(nullable = false) // Indica que este campo no puede ser nulo en la base de datos
    private String climateType2;

    @Column(nullable = false) // Indica que este campo no puede ser nulo en la base de datos
    private String accommodationType3;

    @Column(nullable = false) // Indica que este campo no puede ser nulo en la base de datos
    private String activityType4;

    @Column(nullable = false) // Indica que este campo no puede ser nulo en la base de datos
    private String stayDuration;

    @Column(nullable = false) // Indica que este campo no puede ser nulo en la base de datos
    private String ageRange;

  //  @Column(nullable = false) // Indica que este campo no puede ser nulo en la base de datos
  //  private User user; // Campo que referencia a la clase User - no se debe utilizar este código en las entidades

    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @ManyToOne ( cascade = CascadeType.ALL, fetch = FetchType.LAZY)// Indica una relación de muchos a uno con otra entidad
    @JoinColumn(name = "user_id", nullable = false) // Define la columna de unión para la relación y que no puede ser nula
    private UserEntity userEntity; // Campo que referencia a la entidad UserEntity

    @OneToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn (name = "destinos_id", nullable = false)
    private DestinosEntity destinosEntity;






    //Para que sirve esta parte del código? "abajo"

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}



