package com.eafit.retoamadeus.Controllers;
import com.eafit.retoamadeus.contracts.request.DestinosRequest;
import com.eafit.retoamadeus.contracts.request.UserQueryRequest;
import com.eafit.retoamadeus.contracts.responses.DestinosResponse;
import com.eafit.retoamadeus.contracts.responses.UserQueryResponse;
import com.eafit.retoamadeus.entities.DestinosEntity;
import com.eafit.retoamadeus.logic.Logica;
import com.eafit.retoamadeus.mappers.implementation.DestinoMapper;
import com.eafit.retoamadeus.mappers.intefaces.DestinoInterface;
import com.eafit.retoamadeus.models.DestinosModel;
import com.eafit.retoamadeus.models.DetailsVuelosAHotelsModel;
import com.eafit.retoamadeus.models.UserQuerysModel;
import com.eafit.retoamadeus.repositories.DestinoRepository;
import com.eafit.retoamadeus.services.DestinoService;
import com.eafit.retoamadeus.services.DetailsVuelosAHotelsService;
import com.eafit.retoamadeus.services.DetallesDestinoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/details")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class DetailsVuelosAHotelsControllers {


    private final DetailsVuelosAHotelsService detailsService;

    // metodo que se crea automaticamente, una vez se tenga lo detallesDestinos creados - explicitamente
    // el atributo nombreDestino
    @PostMapping("/create/{nombreDestino}")
    public ResponseEntity<List<DetailsVuelosAHotelsModel>> createHotelsAFlights(@PathVariable String nombreDestino) {
        List <DetailsVuelosAHotelsModel> detalles = detailsService.createDetailsForDestinity(nombreDestino);
        return ResponseEntity.ok(detalles);
    }

    // Endpoint para listar los detalles de un destino
    @GetMapping ("/get/{nombreDestino}")
    public ResponseEntity<List<DetailsVuelosAHotelsModel>> listDetails(@PathVariable String nombreDestino) {
        List<DetailsVuelosAHotelsModel> detalles = detailsService.listDetailsForDestinity(nombreDestino);
        return ResponseEntity.ok(detalles);
    }




}
