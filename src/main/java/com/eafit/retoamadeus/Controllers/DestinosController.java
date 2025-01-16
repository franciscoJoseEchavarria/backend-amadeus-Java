package com.eafit.retoamadeus.Controllers;


import com.eafit.retoamadeus.contracts.request.DestinosRequest;
import com.eafit.retoamadeus.contracts.responses.DestinosResponse;
import com.eafit.retoamadeus.entities.DestinosEntity;
import com.eafit.retoamadeus.mappers.implementation.DestinoMapper;
import com.eafit.retoamadeus.repositories.DestinoRepository;
import com.eafit.retoamadeus.services.DestinoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/destinos")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")

public class DestinosController {

    private final DestinoService destinoService;

    private final DestinoRepository destinoRepository;
    private final DestinoMapper destinoMapper;

    @PostMapping ("/create")
    public DestinosResponse createDestino(@RequestBody DestinosRequest destinosRequest) {
        return destinoService.save(destinosRequest);
    }

    @GetMapping ("/all")
    public List<DestinosResponse> getAllDestinos() {
        return destinoService.findAll();
    }




}
