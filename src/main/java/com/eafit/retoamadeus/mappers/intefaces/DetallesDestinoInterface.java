package com.eafit.retoamadeus.mappers.intefaces;

import com.eafit.retoamadeus.contracts.responses.DetallesDestinosResponse;
import com.eafit.retoamadeus.entities.DetallesDestinosEntity;
import com.eafit.retoamadeus.models.DetallesDestinosModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")


public interface DetallesDestinoInterface {



        List<DetallesDestinosResponse> mapDetallesDestinosModelListToDetallesDestinosResponseList(List <DetallesDestinosModel> entity);

        DetallesDestinosResponse  mapDetallesDestinoModelToDetallesDestinoResponse (DetallesDestinosModel entity);
}
