package com.eafit.retoamadeus.mappers.intefaces;


import com.eafit.retoamadeus.contracts.request.DestinosRequest;
import com.eafit.retoamadeus.contracts.request.UserQueryRequest;
import com.eafit.retoamadeus.contracts.responses.DestinosResponse;
import com.eafit.retoamadeus.entities.DestinosEntity;
import com.eafit.retoamadeus.models.DestinosModel;
import com.eafit.retoamadeus.models.UserQuerysModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


// las interfaces conectan con los controladores ....... del request al modelo y del modelo al response

@Mapper(componentModel = "spring")
public interface DestinoInterface {




    @Mapping(target = "id", ignore = true)
    DestinosModel mapDestinoRequestToDestinoModel(DestinosRequest destinosRequest);

    List<DestinosEntity> mapDestinoRequestListToDestinoEntityList(List<DestinosRequest> destinosRequestList);

    List<DestinosResponse> mapDestinosEntityListToDestinoResponseList(List<DestinosEntity> destinosEntityList);

    List<DestinosResponse> mapDestinoModelListToDestinoResponseList(List<DestinosModel> destinosModelList);

    DestinosResponse mapDestinoModelToDestinoResponse(DestinosModel destinosModel);

    // Agrega este método para mapear un DestinosEntity a DestinosResponse
    DestinosResponse map(DestinosEntity destinosEntity);


}
