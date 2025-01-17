package com.eafit.retoamadeus.mappers.intefaces;


import com.eafit.retoamadeus.contracts.request.DestinosRequest;
import com.eafit.retoamadeus.contracts.request.UserQueryRequest;
import com.eafit.retoamadeus.contracts.responses.DestinosResponse;
import com.eafit.retoamadeus.entities.DestinosEntity;
import com.eafit.retoamadeus.models.UserQuerysModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DestinoInterface {


    DestinosEntity mapDestinoRequestToDestinoEntity(DestinosRequest destinosRequest);


    DestinosResponse mapDestinosEntityToDestinoResponse(DestinosEntity destinosEntity);


    List<DestinosEntity> mapDestinoRequestListToDestinoEntityList(List<DestinosRequest> destinosRequestList);

    List<DestinosResponse> mapDestinosEntityListToDestinoResponseList(List<DestinosEntity> destinosEntityList);




}
