package com.eafit.retoamadeus.models;

import lombok.*;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter

public class DetailsVuelosAHotelsModel {
    private String nombreDestino;
    private List<FlightsModels> flights;
    private List<HotelModel> Hotels;
}
