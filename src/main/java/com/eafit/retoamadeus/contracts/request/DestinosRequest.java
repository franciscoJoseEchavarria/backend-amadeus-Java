package com.eafit.retoamadeus.contracts.request;


import com.eafit.retoamadeus.models.User;
import com.eafit.retoamadeus.models.UserQuerysModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class DestinosRequest {


    @JsonProperty("pDestino")
    private String pDestino;

    @JsonProperty("pClima")
    private String pClima;

    @JsonProperty("pActividad")
    private String pActividad;

    @JsonProperty("pAlojamiento")
    private String pAlojamiento;

    @JsonProperty("pDuracion")
    private String pDuracion;

    @JsonProperty("pRangoEdad")
    private String pRangoEdad;
    private User user;
    private UserQuerysModel userQuerysModel;


}
