
package com.eafit.retoamadeus.logic;

import com.eafit.retoamadeus.contracts.request.DestinosRequest;
import com.eafit.retoamadeus.models.DestinosModel;
import com.eafit.retoamadeus.repositories.DestinoRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Service
public class Logica {

    @Autowired
    private DestinoRepository destinoRepository;

    public DestinosModel logicaNegocio(DestinosRequest destinosRequest) {
        String environmentType1 = destinosRequest.getPDestino();
        String climateType2 = destinosRequest.getPClima();
        String accommodationType3 = destinosRequest.getPActividad();
        String activityType4 = destinosRequest.getPAlojamiento();
        String stayDuration = destinosRequest.getPDuracion();
        String ageRange = destinosRequest.getPRangoEdad();

        String key = String.join("|", environmentType1, climateType2, accommodationType3, activityType4, stayDuration, ageRange);

        Map<String, String[]> destinosMap = new HashMap<>();
        destinosMap.put("Playa|Caluroso|Relax y Bienestar|Hotel de Lujo|1-2 semanas|Menos de 30 años", new String[]{"Playa del Carmen", "Santorini"});
        destinosMap.put("Playa|Caluroso|Cultura y Museos|Airbnb|Menos de una semana|Menos de 30 años", new String[]{"Cartagena", "Barcelona"});
        destinosMap.put("Playa|Templado|Cultura y Museos|Hotel de Lujo|1-2 semanas|30-50 años", new String[]{"Rio de Janeiro", "Lisboa"});
        destinosMap.put("Montaña|Frío|Deportes y Aventuras|Hostal o Albergue|1-2 semanas|Menos de 30 años", new String[]{"Bariloche", "Interlaken"});
        destinosMap.put("Montaña|Templado|Cultura y Museos|Airbnb|1-2 semanas|Más de 50 años", new String[]{"Cusco", "Granada"});
        destinosMap.put("Montaña|Frío|Deportes y Aventuras|Hotel de Lujo|1-2 semanas|30-50 años", new String[]{"Banff", "Zermatt"});
        destinosMap.put("Ciudad|Templado|Cultura y Museos|Hotel de Lujo|1-2 semanas|Más de 50 años", new String[]{"Nueva York", "París"});

        String[] destinos = destinosMap.getOrDefault(key, new String[]{"Bora Bora", "Dubái"});

        System.out.println("destinoEuropa = " + destinos[1]);
        System.out.println("destinoAmerica = " + destinos[0]);

        System.out.println("destinos = " + destinosMap);

        return DestinosModel.builder()
                .destinoAmerica(destinos[0])
                .destinoEuropa(destinos[1])
                .build();


    }
}