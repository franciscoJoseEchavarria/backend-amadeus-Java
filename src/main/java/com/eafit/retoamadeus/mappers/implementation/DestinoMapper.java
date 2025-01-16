package com.eafit.retoamadeus.mappers.implementation;

// Importa las clases necesarias
import com.eafit.retoamadeus.contracts.request.DestinosRequest;
import com.eafit.retoamadeus.contracts.responses.DestinosResponse;
import com.eafit.retoamadeus.entities.DestinosEntity;
import com.eafit.retoamadeus.mappers.intefaces.DestinoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component // Anotación que indica que esta clase es un componente de Spring
public class DestinoMapper {

    @Autowired // Inyección de dependencias de Spring para la interfaz DestinoInterface
    private DestinoInterface destinoInterface;

    // Método que mapea un objeto DestinosRequest a un objeto DestinosEntity
    public DestinosEntity mapDestinoRequestToDestinoEntity(DestinosRequest destinosRequest) {
        return destinoInterface.mapDestinoRequestToDestinoEntity(destinosRequest);
    }

    // Método que mapea un objeto DestinosEntity a un objeto DestinosResponse
    public DestinosResponse mapDestinosEntityToDestinoResponse(DestinosEntity destinosEntity) {
        return destinoInterface.mapDestinosEntityToDestinoResponse(destinosEntity);
    }

    // Método que mapea una lista de objetos DestinosRequest a una lista de objetos DestinosEntity
    public List<DestinosEntity> mapDestinoRequestListToDestinoEntityList(List<DestinosRequest> destinosRequestList) {
        return destinoInterface.mapDestinoRequestListToDestinoEntityList(destinosRequestList);
    }

    // Método que mapea una lista de objetos DestinosEntity a una lista de objetos DestinosResponse
    public List<DestinosResponse> mapDestinosEntityListToDestinoResponseList(List<DestinosEntity> destinosEntityList) {
        return destinoInterface.mapDestinosEntityListToDestinoResponseList(destinosEntityList);
    }
}



