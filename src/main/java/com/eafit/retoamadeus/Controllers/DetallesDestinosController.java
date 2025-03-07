package com.eafit.retoamadeus.Controllers;

import com.eafit.retoamadeus.contracts.responses.DetallesDestinosResponse;
import com.eafit.retoamadeus.mappers.intefaces.DetallesDestinoInterface;
import com.eafit.retoamadeus.models.DestinosModel;
import com.eafit.retoamadeus.models.DetailsVuelosAHotelsModel;
import com.eafit.retoamadeus.models.DetallesDestinosModel;
import com.eafit.retoamadeus.services.DetailsVuelosAHotelsService;
import com.eafit.retoamadeus.services.DetallesDestinoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detallesdestinos")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")


public class DetallesDestinosController {

    private final DetallesDestinoService detallesDestinoService;
    private final DetallesDestinoInterface detallesDestinoInterface;
    private final DetailsVuelosAHotelsService detailsService;

  // obtener una lista de todos los detalles de los destinos
  @GetMapping("/list")
    public List<DetallesDestinosResponse> getDetallesDestinos() {
      return detallesDestinoInterface.mapDetallesDestinosModelListToDetallesDestinosResponseList
              (detallesDestinoService.findAllDetallesDestinos());
  }

    @GetMapping("/search/{id}")
    public DetallesDestinosResponse getDetallesDestinoById(@PathVariable Long id) {
        DetallesDestinosModel detallesDestinosModel = detallesDestinoService.findDetallesDestinoById(id);
        return detallesDestinoInterface.mapDetallesDestinoModelToDetallesDestinoResponse(detallesDestinosModel);
    }

    // src/main/java/com/eafit/retoamadeus/Controllers/DetallesDestinosController.java
    @PutMapping("/update/{id}")
    public DetallesDestinosResponse updateDetallesDestino(@PathVariable Long id, @RequestBody DetallesDestinosModel detallesDestinosModel) {
        DetallesDestinosModel updatedDetallesDestinosModel = detallesDestinoService.updateDetallesDestino(id, detallesDestinosModel);
        return detallesDestinoInterface.mapDetallesDestinoModelToDetallesDestinoResponse(updatedDetallesDestinosModel);
    }

    // src/main/java/com/eafit/retoamadeus/Controllers/DetallesDestinosController.java
    @DeleteMapping("/delete/{id}")
    public void deleteDetallesDestino(@PathVariable Long id) {
        detallesDestinoService.deleteDetallesDestinoById(id);
    }

    // src/main/java/com/eafit/retoamadeus/Controllers/DetallesDestinosController.java
    @DeleteMapping("/deleteAll")
    public void deleteAllDetallesDestinos() {
        detallesDestinoService.deleteAllDetallesDestinos();
    }



    // obtener una lista de acuerdo a los destino que se encuentran en la tabla destino
    @GetMapping("/destino/{destinoId}")
    public List<DetallesDestinosResponse> getDetallesByDestinoId(@PathVariable Long destinoId) {
        List<DetallesDestinosModel> detalles = detallesDestinoService.findDetallesByDestinoId(destinoId);
        return detallesDestinoInterface.mapDetallesDestinosModelListToDetallesDestinosResponseList(detalles);
    }


}

