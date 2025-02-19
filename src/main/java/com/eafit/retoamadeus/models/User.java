/**
 * Esta clase se encarga de representar lo modelos.
 * En la clase UserService, se utiliza esta clase modelos para realizar las operaciones de 
 * la base de datos. Aqui se pasa al userModel, luego a la entidad, 
 * se guarda a la entidad y regresa al UserModel
 *
 * en los controllers se utiliza el modelo para mapear los request y los responses, 
 * atraves de los servicios que se guaradan en la BD
 * @author  Francisco Echavarría
 * @version 1.0
 */


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

    private Long id; // Identificador único del usuario

    private String name; // Nombre del usuario

    private String email; // Correo electrónico del usuario

    private RoleUser role; // Rol del usuario, que puede ser un valor de la enumeración RoleUser



}
