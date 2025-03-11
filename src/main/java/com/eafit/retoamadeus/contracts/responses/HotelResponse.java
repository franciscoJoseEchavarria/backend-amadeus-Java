package com.eafit.retoamadeus.contracts.responses;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class HotelResponse {
    private Long id;
    private String name;
    private String description;
    private String img;
    private DetallesDestinosResponse detallesDestinos;
}
