/**
 * esta clase se encarga de recibir los datos de la petición del cliente.
 * esta clase es tomada directamente en el controlador para hacer la DTO a los modelos, entidades, modelos y response.
 * @author  Francisco Echavarría
 * @version 1.0
 */


package com.eafit.retoamadeus.contracts.request;

import com.eafit.retoamadeus.models.RoleUser;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequest {

    private String name;

    private String email;


    // este @JsonFormat es para que el formato de la fecha sea yyyy-MM-dd,
    // si no se pone, el formato por defecto es el siguiente: "yyyy-MM-dd'T'HH:mm:ss.SSSZ"
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private RoleUser role;
}

