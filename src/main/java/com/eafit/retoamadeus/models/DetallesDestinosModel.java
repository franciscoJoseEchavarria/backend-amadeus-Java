package com.eafit.retoamadeus.models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter


public class DetallesDestinosModel {

    private Long id;
    private String nombreDestino ;
    private String img;
    private String pais;
    private String idioma;
    private String lugarImperdible;

    private DestinosModel destinosModel;
}
