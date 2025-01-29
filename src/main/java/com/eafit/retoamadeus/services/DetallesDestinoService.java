package com.eafit.retoamadeus.services;

import com.eafit.retoamadeus.contracts.request.DestinosRequest;
import com.eafit.retoamadeus.entities.DestinosEntity;
import com.eafit.retoamadeus.entities.DetallesDestinosEntity;
import com.eafit.retoamadeus.logic.Logica;
import com.eafit.retoamadeus.logic.LogicaDetallesDestinos;
import com.eafit.retoamadeus.mappers.implementation.DetallesdestinosMapper;
import com.eafit.retoamadeus.models.DestinosModel;
import com.eafit.retoamadeus.models.DetallesDestinosModel;
import com.eafit.retoamadeus.repositories.DestinoRepository;
import com.eafit.retoamadeus.repositories.DetallesDestinoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DetallesDestinoService {

    private final Logica logica;
    private final LogicaDetallesDestinos logicaDetallesDestinos;
    private final DestinoRepository destinoRepository;
    private final DetallesDestinoRepository detallesDestinoRepository;
    private final DetallesdestinosMapper detallesdestinosMapper;

    public DetallesDestinoService(LogicaDetallesDestinos logicaDetallesDestinos,
                                  DestinoRepository destinoRepository,
                                  DetallesDestinoRepository detallesDestinoRepository,
                                  Logica logica,
                                  DetallesdestinosMapper detallesdestinosMapper) {
        this.logicaDetallesDestinos = logicaDetallesDestinos;
        this.destinoRepository = destinoRepository;
        this.detallesDestinoRepository = detallesDestinoRepository;
        this.logica = logica;
        this.detallesdestinosMapper = detallesdestinosMapper;
    }

    public List<DetallesDestinosModel> crearDetallesDestinos (DestinosEntity destinosEntity,
                                                             DestinosRequest destinosRequest) {

        // Verificar si el destino existe
        DestinosEntity destino = destinoRepository.findById(destinosEntity.getId())
                .orElseThrow(() -> new RuntimeException("Destino no encontrado"));

        // Obtener detalles de los destinos a partir de la lógica
        List<DetallesDestinosModel> detallesDestinosModels = logicaDetallesDestinos.obtenerDetalleDestinos(
                logica.logicaNegocio(destinosRequest)
        );

        // Lista para almacenar las entidades creadas
        List<DetallesDestinosModel> detallesGuardados = new ArrayList<>();

        // Crear y guardar cada entidad basada en los modelos
        for (DetallesDestinosModel modelo : detallesDestinosModels) {
            DetallesDestinosEntity detallesDestinosEntity = new DetallesDestinosEntity();

            // Mapear los valores del modelo a la entidad
            detallesDestinosEntity.setNombreDestino(modelo.getNombreDestino());
            detallesDestinosEntity.setImg(modelo.getImg());
            detallesDestinosEntity.setPais(modelo.getPais());
            detallesDestinosEntity.setIdioma(modelo.getIdioma());
            detallesDestinosEntity.setLugarImperdible(modelo.getLugarImperdible());
            detallesDestinosEntity.setDestinosEntity(destino);

            // Guardar la entidad en la base de datos
            detallesDestinosEntity = detallesDestinoRepository.save(detallesDestinosEntity);

            // Mapear la entidad guardada de vuelta al modelo
            detallesGuardados.add(detallesdestinosMapper.mapDetallesDestinoEntityToDetallesDestinoModel(detallesDestinosEntity));
        }

        return detallesGuardados;
    }
}

    /** Meotodo para crear detalle destino
     * Importante leer este metodo con el anterior para comprende aún mejor
    public DetallesDestinosModel crearDetallesDestinos (DestinosModel destinosModel, DestinosEntity destinosEntity,
                                                        DestinosRequest destinosRequest) {

        DestinosEntity destino = destinoRepository.findById(destinosEntity.getId())
                .orElseThrow(() -> new RuntimeException("Destino no encontrado"));

       List <DetallesDestinosModel> detallesdestinosModel = logicaDetallesDestinos.obtenerDetalleDestinos(logica.logicaNegocio(destinosRequest));

        DetallesDestinosEntity detallesDestinosEntity = null;

        detallesDestinosEntity.setNombreDestino(detallesdestinosModel.get(0).getNombreDestino());
        detallesDestinosEntity.setImg(detallesdestinosModel.get(0).getImg());
        detallesDestinosEntity.setPais(detallesdestinosModel.get(0).getPais());
        detallesDestinosEntity.setIdioma(detallesdestinosModel.get(0).getIdioma());
        detallesDestinosEntity.setLugarImperdible(detallesdestinosModel.get(0).getLugarImperdible());
        detallesDestinosEntity.setDestinosEntity(destino);

        detallesDestinoRepository.save(detallesDestinosEntity);

        detallesDestinosEntity.setDestinosEntity(destino);

        detallesDestinosEntity.setNombreDestino(detallesdestinosModel.get(1).getNombreDestino());
        detallesDestinosEntity.setImg(detallesdestinosModel.get(1).getImg());
        detallesDestinosEntity.setPais(detallesdestinosModel.get(1).getPais());
        detallesDestinosEntity.setIdioma(detallesdestinosModel.get(1).getIdioma());
        detallesDestinosEntity.setLugarImperdible(detallesdestinosModel.get(1).getLugarImperdible());
        detallesDestinosEntity.setDestinosEntity(destino);

        detallesDestinosEntity = detallesDestinoRepository.save(detallesDestinosEntity);


        return detallesdestinosMapper.mapDetallesDestinoEntityToDetallesDestinoModel(detallesDestinosEntity);

    }
    */

