

package com.eafit.retoamadeus.logic;
import java.util.List;
import java.util.Map;

import com.eafit.retoamadeus.models.DetallesDestinosModel;
import com.eafit.retoamadeus.models.FlightsModels;
import com.eafit.retoamadeus.models.HotelModel;
import org.springframework.stereotype.Component;

/*Logica para encontrar las recomendaciones de vuelos
*Esta clase esta planteada para tener dos respuesta por cada destino que se desee visitar
* esta tien su clase principal en flightsModel y flightsEntity
* en los servicios esta clase se debe transferir los datos diirectamente a DetailsVuelosaHotelsMappe,
* en su servicio se maneja la lógica de la respuesta
* se utiliza este mapper para los principios SOLID y separar responsabilidades
*/

@Component
public class LogicFlights {

    private final Map <String, List<FlightsModels>> flightsRecomendatios = Map.ofEntries(
            Map.entry("Playa del Carmen",  List.of(
                    FlightsModels.builder()
                            .name("AeroMexico")
                            .img("/assets/img/flights/AeroMexico.jpg")
                            .description("Vuelo directo")
                            .build(),
                    FlightsModels.builder()
                            .name("Viva Aerobus")
                            .img("/assets/img/flights/VivaAerobus.jpg")
                            .description("Vuelo con escala")
                            .build()
            )),
            Map.entry("Santorini",  List.of(
                    FlightsModels.builder()
                            .name("Iberia")
                            .img("/assets/img/flights/Iberia.jpg")
                            .description("Vuelo directo")
                            .build(),
                    FlightsModels.builder()
                            .name("Vueling")
                            .img("/assets/img/flights/Vueling.jpg")
                            .description("Vuelo con escala")
                            .build()
            )),
            Map.entry("Cartagena",  List.of(
                    FlightsModels.builder()
                            .name("Avianca")
                            .img("/assets/img/flights/Avianca.jpg")
                            .description("Vuelo directo")
                            .build(),
                    FlightsModels.builder()
                            .name("LATAM")
                            .img("/assets/img/flights/LATAM.jpg")
                            .description("Vuelo con escala")
                            .build()
            )),
            Map.entry("Rio de Janeiro",  List.of(
                    FlightsModels.builder()
                            .name("GOL")
                            .img("/assets/img/flights/GOL.jpg")
                            .description("Vuelo directo")
                            .build(),
                    FlightsModels.builder()
                            .name("LATAM")
                            .img("/assets/img/flights/LATAM.jpg")
                            .description("Vuelo con escala")
                            .build()
            )),
            Map.entry("Bariloche",  List.of(
                    FlightsModels.builder()
                            .name("Aerolineas Argentinas")
                            .img("/assets/img/flights/AerolineasArgentinas.jpg")
                            .description("Vuelo directo")
                            .build(),
                    FlightsModels.builder()
                            .name("LATAM")
                            .img("/assets/img/flights/LATAM.jpg")
                            .description("Vuelo con escala")
                            .build()
            )),
            Map.entry("Cusco",  List.of(
                    FlightsModels.builder()
                            .name("LATAM")
                            .img("/assets/img/flights/LATAM.jpg")
                            .description("Vuelo directo")
                            .build(),
                    FlightsModels.builder()
                            .name("Viva Air")
                            .img("/assets/img/flights/VivaAir.jpg")
                            .description("Vuelo con escala")
                            .build()
            )),
            Map.entry("Banff",  List.of(
                    FlightsModels.builder()
                            .name("Air Canada")
                            .img("/assets/img/flights/AirCanada.jpg")
                            .description("Vuelo directo")
                            .build(),
                    FlightsModels.builder()
                            .name("WestJet")
                            .img("/assets/img/flights/WestJet.jpg")
                            .description("Vuelo con escala")
                            .build()
            )),
            Map.entry("Nueva York",  List.of(
                    FlightsModels.builder()
                            .name("Delta")
                            .img("/assets/img/flights/Delta.jpg")
                            .description("Vuelo directo")
                            .build(),
                    FlightsModels.builder()
                            .name("American Airlines")
                            .img("/assets/img/flights/AmericanAirlines.jpg")
                            .description("Vuelo con escala")
                            .build()
            )),
            Map.entry("Barcelona",  List.of(
                    FlightsModels.builder()
                            .name("Iberia")
                            .img("/assets/img/flights/Iberia.jpg")
                            .description("Vuelo directo")
                            .build(),
                    FlightsModels.builder()
                            .name("Vueling")
                            .img("/assets/img/flights/Vueling.jpg")
                            .description("Vuelo con escala")
                            .build()
            )),
            Map.entry("Lisboa",  List.of(
                    FlightsModels.builder()
                            .name("TAP Portugal")
                            .img("/assets/img/flights/TAPPortugal.jpg")
                            .description("Vuelo directo")
                            .build(),
                    FlightsModels.builder()
                            .name("Ryanair")
                            .img("/assets/img/flights/Ryanair.jpg")
                            .description("Vuelo con escala")
                            .build()
            )),
            Map.entry("Interlaken",  List.of(
                    FlightsModels.builder()
                            .name("Swiss")
                            .img("/assets/img/flights/Swiss.jpg")
                            .description("Vuelo directo")
                            .build(),
                    FlightsModels.builder()
                            .name("Edelweiss Air")
                            .img("/assets/img/flights/EdelweissAir.jpg")
                            .description("Vuelo con escala")
                            .build()
            )),
            Map.entry("Granada",  List.of(
                    FlightsModels.builder()
                            .name("Vueling")
                            .img("/assets/img/flights/Vueling.jpg")
                            .description("Vuelo directo")
                            .build(),
                    FlightsModels.builder()
                            .name("Ryanair")
                            .img("/assets/img/flights/Ryanair.jpg")
                            .description("Vuelo con escala")
                            .build()
            )),
            Map.entry("Zermatt",  List.of(
                    FlightsModels.builder()
                            .name("Swiss")
                            .img("/assets/img/flights/Swiss.jpg")
                            .description("Vuelo directo")
                            .build(),
                    FlightsModels.builder()
                            .name("Edelweiss Air")
                            .img("/assets/img/flights/EdelweissAir.jpg")
                            .description("Vuelo con escala")
                            .build()
            )),
            Map.entry("París",  List.of(
                    FlightsModels.builder()
                            .name("Air France")
                            .img("/assets/img/flights/AirFrance.jpg")
                            .description("Vuelo directo")
                            .build(),
                    FlightsModels.builder()
                            .name("Vueling")
                            .img("/assets/img/flights/Vueling.jpg")
                            .description("Vuelo con escala")
                            .build()
            )),
            Map.entry("Bora Bora",  List.of(
                    FlightsModels.builder()
                            .name("Air Tahiti")
                            .img("/assets/img/flights/AirTahiti.jpg")
                            .description("Vuelo directo")
                            .build(),
                    FlightsModels.builder()
                            .name("Hawaiian Airlines")
                            .img("/assets/img/flights/HawaiianAirlines.jpg")
                            .description("Vuelo con escala")
                            .build()
            )),
            Map.entry("Dubaí",  List.of(
                    FlightsModels.builder()
                            .name("Emirates")
                            .img("/assets/img/flights/Emirates.jpg")
                            .description("Vuelo directo")
                            .build(),
                    FlightsModels.builder()
                            .name("Flydubai")
                            .img("/assets/img/flights/Flydubai.jpg")
                            .description("Vuelo con escala")
                            .build()
            ))
    );

    public List<FlightsModels> getFlightsRecomendation(String nombreDestino) {
        return flightsRecomendatios.getOrDefault(nombreDestino, List.of());
    }
}
