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


        // ciidad {ciudad, ruta de imagen frontend, pais, idioma, lugar imperdible}
        Map<String, String[]> destinosMap = new HashMap<>();
        destinosMap.put("Playa del Carmen", new String[]{destinoAmerica, "/assets/img/citys/PlayaDelCarmen.jpg", "México", "Español", "Castillo San Felipe"});
        destinosMap.put("Santorini", new String[]{"Santorini", "/assets/img/citys/Santorini.jpg", "Grecia", "Griego", "Oia"});
        destinosMap.put("Cartagena", new String[]{destinoAmerica, "/assets/img/citys/Cartagena.jpg", "Colombia", "Español", "Murallas de Cartagena"});
        destinosMap.put("Rio de Janeiro", new String[]{destinoAmerica, "/assets/img/citys/RioDeJaneiro.jpg", "Beasil", "Portugues", "Cristo Redentor"});
        destinosMap.put("Bariloche", new String[]{destinoAmerica, "/assets/img/citys/Bariloche.jpg", "Argentina", "Español", "Cerro Catedral"});
        destinosMap.put("Cusco", new String[]{destinoAmerica, "/assets/img/citys/Cusco.jpg", "Perú", "Español", "Machu Picchu"});
        destinosMap.put("Banff", new String[]{destinoAmerica, "/assets/img/citys/Banff.jpg", "Cánada", "ingles y Francés", "Lago Moraine"});
        destinosMap.put("Nueva York", new String[]{destinoAmerica, "/assets/img/citys/NuevaYork.jpg", "EEUU", "Inglés", "Estatua de la Libertad"});
        destinosMap.put("Barcelona", new String[]{"Barcelona", "/assets/img/citys/Barcelona.jpg", "España", "Español", "Sagrada Familia"});
        destinosMap.put("Lisboa", new String[]{"Lisboa", "/assets/img/citys/Lisboa.jpg", "Portugal", "Portugués", "Torre de Belém"});
        destinosMap.put("Interlaken", new String[]{"Interlaken", "/assets/img/citys/Interlaken.jpg", "Suiza", "Alemán", "Jungfrau"});
        destinosMap.put("Granada", new String[]{"Granada", "/assets/img/citys/Granada.jpg", "España", "Español", "Alhambra"});
        destinosMap.put("Zermatt", new String[]{"Zermatt", "/assets/img/citys/Zermatt.jpg", "Suiza", "Alemán", "Matterhorn"});
        destinosMap.put("París", new String[]{"París", "/assets/img/citys/Paris.jpg", "Francia", "Francés", "Torre Eiffel"});
        destinosMap.put("Bora Bora", new String[]{"Bora Bora", "/assets/img/citys/BoraBora.jpg", "Palmas", "Español", "Matterhorn"});
        destinosMap.put("Dubái", new String[]{"Dubaí", "/assets/img/citys/Dubai.jpg", "Emiratos Árabes Unidos", "árabe", "Burj Khalifa"});



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

