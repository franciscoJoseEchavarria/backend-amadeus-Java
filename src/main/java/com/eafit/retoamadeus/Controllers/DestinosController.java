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
import com.eafit.retoamadeus.models.UserQuerysModel;
import com.eafit.retoamadeus.repositories.DestinoRepository;
import com.eafit.retoamadeus.services.DestinoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/destinos")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")

public class DestinosController {

    private final DestinoService destinoService;
    private final DestinoInterface destinoInterface;


    private final Logica logica;

    @PostMapping ("/create")
    public ResponseEntity<DestinosModel> crearDestino(@RequestBody DestinosRequest destinosRequest) {

        try {
            // Imprime el contenido del objeto destinosRequest en formato JSON
            System.out.println("Contenido de destinosRequest en formato JSON: " +
                    new ObjectMapper().writeValueAsString(destinosRequest));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


        DestinosModel destinosModel = destinoService.crearDestino(destinosRequest);


        return ResponseEntity.status(HttpStatus.CREATED).body(destinosModel);


    }




    @GetMapping("/encontrar/{id}")
    public ResponseEntity<DestinosModel> obtenerDestinoId(@PathVariable Long id){
        return ResponseEntity.ok(destinoService.obtenerDestinoId(id));
    }


    public List<DestinosResponse> getDestinos() {
        return destinoInterface.mapDestinoModelListToDestinoResponseList(destinoService.findAll());
    }






}
