package com.eafit.retoamadeus.Controllers;


import com.eafit.retoamadeus.contracts.responses.HotelResponse;
import com.eafit.retoamadeus.mappers.intefaces.HotelInterface;
import com.eafit.retoamadeus.services.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class HotelController {

    private final HotelService hotelService;
    private final HotelInterface hotelInterface;


    @PostMapping("/create")
    public List<HotelResponse> createHotel(@RequestParam String nombreDestino, @RequestParam Long destinoId) {
        return hotelInterface.mapHotelModelListToHotelResponseList(hotelService.createHotel(nombreDestino, destinoId));
    }

    @GetMapping("/list")
    public List<HotelResponse> getHotelList() {
        return hotelInterface.mapHotelModelListToHotelResponseList(hotelService.getHotelList());
    }

}
