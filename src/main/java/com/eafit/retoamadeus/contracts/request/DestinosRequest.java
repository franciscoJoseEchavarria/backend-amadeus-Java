package com.eafit.retoamadeus.contracts.request;


import com.eafit.retoamadeus.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class DestinosRequest {

    private String pDestino;
    private String pclima;
    private String pActividad;
    private String pAlojamiento;
    private String pduración;
    private String prangoEdad;
    private User user;
}
