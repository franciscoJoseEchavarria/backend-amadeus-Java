package com.eafit.retoamadeus.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity(name = "DetalleDestinoEntity") // Define la clase como una entidad JPA y la mapea a la tabla 'userQuerysEntities'
@Data // Genera automáticamente los métodos getter, setter, equals, hashCode y toString
@NoArgsConstructor // Genera un constructor sin argumentos
@AllArgsConstructor // Genera un constructor con todos los argumentos
@Builder // Permite usar el patrón de diseño builder para crear instancias de la clase


public class DetallesDestinosEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (nullable = false)
    private String nombreDestino ;
    @Column (nullable = false)
    private String img;
    @Column (nullable = false)
    private String pais;
    @Column (nullable = false)
    private String idioma;
    @Column (nullable = false)
    private String lugarImperdible;
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "Det-destino-id", nullable = false)
    private DestinosEntity destinosEntity;

    @OneToMany  (mappedBy = "detallesDestinosEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY) //mappedBy, mapea destinoEntity de la clase FlightsEntity
    @OrderColumn(name = "index_flight")
    List<FlightsEntity> flightsEntityList;

    @OneToMany  (mappedBy = "detallesDestinosEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY) //mappedBy, mapea destinoEntity de la clase HotelsEntity
    @OrderColumn(name = "index_hotel")
    List <HotelsEntity> hotelsEntityList;

}
