package com.eafit.retoamadeus.contracts.responses;

import com.eafit.retoamadeus.models.DestinosModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class DetallesDestinosResponse {

    private Long id;
    private String nombreDestino ;
    private String img;
    private String pais;
    private String idioma;
    private String lugarImperdible;
    private DestinosModel destinosModel;



}
