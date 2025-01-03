package com.eafit.retoamadeus.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Data //getters, setters, equals, hashcode, tostring
@NoArgsConstructor //constructor sin argumentos
@AllArgsConstructor //constructor con todos los argumentos
@Builder //patron de diseño builder

@Table(name = "user") //nombre de la tabla en la base de datos

public class User {

    private Long id;

    private String name;

    private String email;

    private RoleUser role;

}
