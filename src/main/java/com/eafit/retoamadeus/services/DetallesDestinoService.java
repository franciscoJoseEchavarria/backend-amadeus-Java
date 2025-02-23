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
import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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


    //crea los detalles de los Destinos
    @Transactional
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

            System.out.println(" detalles destino Models " + detallesDestinosModels);
            System.out.println("detallesDestinosEntity = " + detallesDestinosEntity);

            // Mapear la entidad guardada de vuelta al modelo
            detallesGuardados.add(detallesdestinosMapper.mapDetallesDestinoEntityToDetallesDestinoModel(detallesDestinosEntity));

        }

        return detallesGuardados;
    }


    public List <DetallesDestinosModel> findAllDetallesDestinos() {
        List<DetallesDestinosEntity> detallesDestinosEntities = detallesDestinoRepository.findAll();
        List<DetallesDestinosModel> detallesDestinosModels = new ArrayList<>();

        for (DetallesDestinosEntity detallesDestinosEntity : detallesDestinosEntities) {
            detallesDestinosModels.add(detallesdestinosMapper.mapDetallesDestinoEntityToDetallesDestinoModel(detallesDestinosEntity));
        }

        return detallesDestinosModels;
    }

    public DetallesDestinosModel findDetallesDestinoById(Long id) {
        DetallesDestinosEntity detallesDestinosEntity = detallesDestinoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Detalles destino no encontrado"));

        return detallesdestinosMapper.mapDetallesDestinoEntityToDetallesDestinoModel(detallesDestinosEntity);
    }

    public DetallesDestinosModel updateDetallesDestino(Long id, DetallesDestinosModel detallesDestinosModel) {
        DetallesDestinosEntity detallesDestinosEntity = detallesDestinoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Detalles destino no encontrado"));

        detallesDestinosEntity.setNombreDestino(detallesDestinosModel.getNombreDestino());
        detallesDestinosEntity.setImg(detallesDestinosModel.getImg());
        detallesDestinosEntity.setPais(detallesDestinosModel.getPais());
        detallesDestinosEntity.setIdioma(detallesDestinosModel.getIdioma());
        detallesDestinosEntity.setLugarImperdible(detallesDestinosModel.getLugarImperdible());

        detallesDestinosEntity = detallesDestinoRepository.save(detallesDestinosEntity);

        return detallesdestinosMapper.mapDetallesDestinoEntityToDetallesDestinoModel(detallesDestinosEntity);
    }

    // Metodo para obtener detalles de un destino por su id
    public List<DetallesDestinosModel> findDetallesByDestinoId(Long destinoId) {
        List<DetallesDestinosEntity> entities = detallesDestinoRepository.findByDestinosEntity_Id(destinoId);
        return entities.stream()
                .map(detallesdestinosMapper::mapDetallesDestinoEntityToDetallesDestinoModel)
                .collect(Collectors.toList());
    }


    public void deleteDetallesDestinoById(Long id) {
        if (!detallesDestinoRepository.existsById(id)) {
            throw new RuntimeException("Detalles destino no encontrado");
        }
        detallesDestinoRepository.deleteById(id);
    }


    public void deleteAllDetallesDestinos() {
        detallesDestinoRepository.deleteAll();
    }


}


