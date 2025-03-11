package com.eafit.retoamadeus.models;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class HotelModel {
    private Long id;
    private String name;
    private String description;
    private String img;
    private DetallesDestinosModel detallesDestinos;


}
