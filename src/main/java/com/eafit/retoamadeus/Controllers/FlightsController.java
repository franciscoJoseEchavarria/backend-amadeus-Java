package com.eafit.retoamadeus.Controllers;


import com.eafit.retoamadeus.contracts.responses.FlightResponse;
import com.eafit.retoamadeus.contracts.responses.HotelResponse;
import com.eafit.retoamadeus.mappers.intefaces.FlightInterface;
import com.eafit.retoamadeus.mappers.intefaces.HotelInterface;
import com.eafit.retoamadeus.services.FlightService;
import com.eafit.retoamadeus.services.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")

public class FlightsController {

    private final FlightService flightService;
    private final FlightInterface flightInterface;


    @PostMapping("/create")
    public List<FlightResponse> createFlight(@RequestParam String nombreDestino, @RequestParam Long destinoId) {
        return flightInterface.mapFlightModelListToFlightResponseList(flightService.createFlights(nombreDestino, destinoId));
    }

    @GetMapping("/list")
    public List<FlightResponse> getFlightList() {
        return flightInterface.mapFlightModelListToFlightResponseList(flightService.getFlightsList());

    }
}
