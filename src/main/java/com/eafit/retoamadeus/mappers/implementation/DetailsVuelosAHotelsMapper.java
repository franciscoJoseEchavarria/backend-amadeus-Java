package com.eafit.retoamadeus.mappers.implementation;


import com.eafit.retoamadeus.entities.DestinosEntity;
import com.eafit.retoamadeus.entities.DetallesDestinosEntity;
import com.eafit.retoamadeus.entities.FlightsEntity;
import com.eafit.retoamadeus.models.DetailsVuelosAHotelsModel;
import com.eafit.retoamadeus.models.FlightsModels;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring" , uses = {HotelMapper.class, FlightsMapper.class}  ) //se llaman hotel mapper y flights mapper

public interface DetailsVuelosAHotelsMapper {

    DetailsVuelosAHotelsModel mapDetallesDestinosEntityToDetailsVuelosAHotelModel (DetallesDestinosEntity detallesDestinosEntity);
    List<DetailsVuelosAHotelsModel> mapDetallesDestinosEntitiesListToDetailsVuelosAHotelsModelsList(List<DetallesDestinosEntity> entities);
}

/* así se utilizaría si fuera con models -- NO BORRAR EXPLICACIÓN
@Component
public class DetallesVuelosHotelesMapper {

    private final HotelMapper hotelMapper;
    private final VueloMapper vueloMapper;

    public DetallesVuelosHotelesMapper(HotelMapper hotelMapper, VueloMapper vueloMapper) {
        this.hotelMapper = hotelMapper;
        this.vueloMapper = vueloMapper;
    }
    public DetallesVuelosHotelesModel toModel(DestinoEntity destinoEntity) {
        if (destinoEntity == null) {
            return null;
        }
        List<HotelModel> hoteles = destinoEntity.getHoteles().stream()
                .map(hotelMapper::toModel)
                .collect(Collectors.toList());
        List<VueloModel> vuelos = destinoEntity.getVuelos().stream()
                .map(vueloMapper::toModel)
                .collect(Collectors.toList());
        return DetallesVuelosHotelesModel.builder()
                .nombreDestino(destinoEntity.getNombreDestino())
                .hoteles(hoteles)
                .vuelos(vuelos)
                .build();
    }
 */
