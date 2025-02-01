package com.eafit.retoamadeus.logic;

import com.eafit.retoamadeus.models.DestinosModel;
import com.eafit.retoamadeus.models.DetallesDestinosModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Data

@Builder
@Service

public class LogicaDetallesDestinos {


    public List <DetallesDestinosModel> obtenerDetalleDestinos(DestinosModel destinosModel) {

        String destinoAmerica = destinosModel.getDestinoAmerica();
        String destinoEuropa = destinosModel.getDestinoEuropa();

        Map<String, String[]> destinosMap = new HashMap<>();
        destinosMap.put("Playa del Carmen", new String[]{destinoAmerica, "img1", "México", "Español", "Castillo San Felipe"});
        destinosMap.put("Cartagena", new String[]{destinoAmerica, "img1", "Colombia", "Español", "Murallas de Cartagena"});
        destinosMap.put("Rio de Janeiro", new String[]{destinoAmerica, "img1", "Beasil", "Portugues", "Cristo Redentor"});
        destinosMap.put("Bariloche", new String[]{destinoAmerica, "img1", "Argentina", "Español", "Cerro Catedral"});
        destinosMap.put("Cusco", new String[]{destinoAmerica, "img1", "Perú", "Español", "Machu Picchu"});
        destinosMap.put("Banff", new String[]{destinoAmerica, "img1", "Cánada", "ingles y Francés", "Lago Moraine"});
        destinosMap.put("Nueva York", new String[]{destinoAmerica, "img1", "EEUU", "Inglés", "Estatua de la Libertad"});
        destinosMap.put("Santorini", new String[]{"Santorini", "img1", "Grecia", "Griego", "Oia"});
        destinosMap.put("Barcelona", new String[]{"Barcelona", "/assets/img/Barcelona.jpg", "España", "Español", "Sagrada Familia"});
        destinosMap.put("Lisboa", new String[]{"Lisboa", "img1", "Portugal", "Portugués", "Torre de Belém"});
        destinosMap.put("Interlaken", new String[]{"Interlaken", "img1", "Suiza", "Alemán", "Jungfrau"});
        destinosMap.put("Granada", new String[]{"Granada", "img1", "España", "Español", "Alhambra"});
        destinosMap.put("Zermatt", new String[]{"Zermatt", "img1", "Suiza", "Alemán", "Matterhorn"});
        destinosMap.put("París", new String[]{"París", "img1", "Francia", "Francés", "Torre Eiffel"});
        destinosMap.put("Bora Bora", new String[]{"Bora Bora", "/assets/img/BoraBora.jpg", "Palmas", "Español", "Matterhorn"});
        destinosMap.put("Dubái", new String[]{"Dubaí", "/assets/img/Dubai.jpg", "Francia", "Francés", "Torre Eiffel"});



        List <DetallesDestinosModel> detallesDestinosModels = new ArrayList<>();

    // Verifica si el mapa de destinos contiene la clave destinoAmerica
        if (destinosMap.containsKey(destinoAmerica)) {
            // Obtiene los detalles del destinoAmerica del mapa
            String[] detalleAmerica = destinosMap.get(destinoAmerica);

            // Crea una instancia de DetallesDestinosModel usando el constructor del patrón Builder
            DetallesDestinosModel detallesDestinosModel = DetallesDestinosModel.builder()
                    .nombreDestino(detalleAmerica[0])  // Asigna el nombre del destino
                    .img(detalleAmerica[1])            // Asigna la imagen del destino
                    .pais(detalleAmerica[2])           // Asigna el país del destino
                    .idioma(detalleAmerica[3])         // Asigna el idioma del destino
                    .lugarImperdible(detalleAmerica[4])// Asigna el lugar imperdible del destino
                    .build();                          // Construye la instancia de DetallesDestinosModel

            // Agrega la instancia de DetallesDestinosModel a la lista detallesDestinosModels
            detallesDestinosModels.add(detallesDestinosModel);
        }
        if (destinosMap.containsKey(destinoEuropa)) {
            String[] detallesEuropa = destinosMap.get(destinoEuropa);
            DetallesDestinosModel detalleEuropa = DetallesDestinosModel.builder()
                    .nombreDestino(detallesEuropa[0])
                    .img(detallesEuropa[1])
                    .pais(detallesEuropa[2])
                    .idioma(detallesEuropa[3])
                    .lugarImperdible(detallesEuropa[4])
                    .destinosModel(destinosModel)
                    .build();
            detallesDestinosModels.add(detalleEuropa);
        }
        return detallesDestinosModels;
    }

}

