

package com.eafit.retoamadeus.logic;

import com.eafit.retoamadeus.contracts.request.DestinosRequest;
import com.eafit.retoamadeus.entities.DestinosEntity;
import com.eafit.retoamadeus.entities.DestinosEntity;
import com.eafit.retoamadeus.entities.UserQueryEntity;
import com.eafit.retoamadeus.models.DestinosModel;
import com.eafit.retoamadeus.models.UserQuerysModel;
import com.eafit.retoamadeus.repositories.DestinoRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        String climateType2 = destinosRequest.getPclima();
        String accommodationType3 = destinosRequest.getPActividad();
        String activityType4 = destinosRequest.getPAlojamiento();
        String stayDuration = destinosRequest.getPduración();
        String ageRange = destinosRequest.getPrangoEdad();

        String destinoAmerica = null;
        String destinoEuropa = null;

        if ("Playa".equals(environmentType1) && "Caluroso".equals(climateType2) &&
            "Relax y Bienestar".equals(accommodationType3) &&
            "Hotel de Lujo".equals(activityType4) &&
            "1-2 semanas".equals(stayDuration) &&
            "Menos de 30 años".equals(ageRange)) {

            destinoAmerica = "Playa del Carmen";
            destinoEuropa = "Santorini";
        } else if ("Playa".equals(environmentType1) && "Caluroso".equals(climateType2) &&
                   "Cultura y Museos".equals(accommodationType3) &&
                   "Airbnb".equals(activityType4) &&
                   "Menos de una semana".equals(stayDuration) &&
                   "Menos de 30 años".equals(ageRange)) {
            destinoAmerica = "Cartagena";
            destinoEuropa = "Barcelona";
        } else if ("Playa".equals(environmentType1) && "Templado".equals(climateType2) &&
                   "Cultura y Museos".equals(accommodationType3) &&
                   "Hotel de Lujo".equals(activityType4) &&
                   "1-2 semanas".equals(stayDuration) &&
                   "30-50 años".equals(ageRange)) {
            destinoAmerica = "Rio de Janeiro";
            destinoEuropa = "Lisboa";
        } else if ("Montaña".equals(environmentType1) && "Frío".equals(climateType2) &&
                   "Deportes y Aventuras".equals(accommodationType3) &&
                   "Hostal o Albergue".equals(activityType4) &&
                   "1-2 semanas".equals(stayDuration) &&
                   "Menos de 30 años".equals(ageRange)) {
            destinoAmerica = "Bariloche";
            destinoEuropa = "Interlaken";
        } else if ("Montaña".equals(environmentType1) && "Templado".equals(climateType2) &&
                   "Cultura y Museos".equals(accommodationType3) &&
                   "Airbnb".equals(activityType4) &&
                   "1-2 semanas".equals(stayDuration) &&
                   "Más de 50 años".equals(ageRange)) {
            destinoAmerica = "Cusco";
            destinoEuropa = "Granada";
        } else if ("Montaña".equals(environmentType1) && "Frío".equals(climateType2) &&
                   "Deportes y Aventuras".equals(accommodationType3) &&
                   "Hotel de Lujo".equals(activityType4) &&
                   "1-2 semanas".equals(stayDuration) &&
                   "30-50 años".equals(ageRange)) {
            destinoAmerica = "Banff";
            destinoEuropa = "Zermatt";
        } else if ("Ciudad".equals(environmentType1) && "Templado".equals(climateType2) &&
                   "Cultura y Museos".equals(accommodationType3) &&
                   "Hotel de Lujo".equals(activityType4) &&
                   "1-2 semanas".equals(stayDuration) &&
                   "Más de 50 años".equals(ageRange)) {
            destinoAmerica = "Nueva York";
            destinoEuropa = "París";
        }

        if (destinoAmerica == null && destinoEuropa == null) {
            destinoAmerica = "Bora Bora";
            destinoEuropa = "Dubaí";
        }

        return DestinosModel.builder()
                .destinoAmerica(destinoAmerica)
                .destinoEuropa(destinoEuropa)
                .build();

    }
}
















/**
package com.eafit.retoamadeus.logic;

import com.eafit.retoamadeus.entities.UserQueryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //getters, setters, equals, hashcode, tostring
@NoArgsConstructor //constructor sin argumentos
@AllArgsConstructor //constructor con todos los argumentos
@Builder //patron de diseño builder


public class Logica {

    private String destinoAmerica;
    private String destinoEuropa;

    public void logicaNegocio (UserQueryEntity userQueryEntity) {

        String environmentType1 = userQueryEntity.getEnvironmentType1();
        String climateType2 = userQueryEntity.getClimateType2();
        String accommodationType3 = userQueryEntity.getAccommodationType3();
        String activityType4 = userQueryEntity.getActivityType4();
        String stayDuration = userQueryEntity.getStayDuration();
        String ageRange = userQueryEntity.getAgeRange();

            if ("Playa".equals(environmentType1) && "Caluroso".equals(climateType2) &&
                "Relax y Bienestar".equals(accommodationType3) &&
                "Hotel de Lujo".equals(activityType4) &&
                "1-2 semanas".equals(stayDuration) &&
                "Menos de 30 años".equals(ageRange)) {

            this.destinoAmerica = "Playa del Carmen";
            this.destinoEuropa = "Santorini";
            }

            else if ("Playa".equals(environmentType1) && "Caluroso".equals(climateType2) &&
                    "Cultura y Museos".equals(accommodationType3) &&
                    "Airbnb".equals(activityType4) &&
                    "Menos de una semana".equals(stayDuration) &&
                    "Menos de 30 años".equals(ageRange)) {
                this.destinoAmerica = "Cartagena";
                this.destinoEuropa = "Barcelona";
            }

            else if ("Playa".equals(environmentType1) && "Templado".equals(climateType2) &&
                    "Cultura y Museos".equals(accommodationType3) &&
                    "Hotel de Lujo".equals(activityType4) &&
                    "1-2 semanas".equals(stayDuration) &&
                    "30-50 años".equals(ageRange)) {

                this.destinoAmerica = "Rio de Janeiro";
                this.destinoEuropa = "Lisboa";
            }

            else if ("Montaña".equals(environmentType1) && "Frío".equals(climateType2) &&
                    "Deportes y Aventuras".equals(accommodationType3) &&
                    "Hostal o Albergue".equals(activityType4) &&
                    "1-2 semanas".equals(stayDuration) &&
                    "Menos de 30 años".equals(ageRange)) {

                this.destinoAmerica = "Bariloche";
                this.destinoEuropa = "Interlaken";
            }

            else if ("Montaña".equals(environmentType1) && "Templado".equals(climateType2) &&
                    "Cultura y Museos".equals(accommodationType3) &&
                    "Airbnb".equals(activityType4) &&
                    "1-2 semanas".equals(stayDuration) &&
                    "Más de 50 años".equals(ageRange)) {

                this.destinoAmerica = "Cusco";
                this.destinoEuropa = "Granada";
            }


            else if ("Montaña".equals(environmentType1) && "Frío".equals(climateType2) &&
                    "Deportes y Aventuras".equals(accommodationType3) &&
                    "Hotel de Lujo".equals(activityType4) &&
                    "1-2 semanas".equals(stayDuration) &&
                    "30-50 años".equals(ageRange)) {

                this.destinoAmerica = "Banff";
                this.destinoEuropa = "Zermatt";
            }



            else if ("Ciudad".equals(environmentType1) && "Templado".equals(climateType2) &&
                "Cultura y Museos".equals(accommodationType3) &&
                "Hotel de Lujo".equals(activityType4) &&
                "1-2 semanas".equals(stayDuration) &&
                "Más de 50 años".equals(ageRange)) {

                this.destinoAmerica = "Nueva York";
                this.destinoEuropa = "París";
            }

            if (this.destinoAmerica == null && this.destinoEuropa == null) {
                this.destinoAmerica = "Bora Bora";
                this.destinoEuropa = "Dubaí";
            }




    }
}


*/



/** otra forma de hacerlo
 public void logicaNegocio(UserQueryEntity userQueryEntity) {
 String environmentType1 = userQueryEntity.getEnvironmentType1();
 String climateType2 = userQueryEntity.getClimateType2();
 String accommodationType3 = userQueryEntity.getAccommodationType3();
 String activityType4 = userQueryEntity.getActivityType4();
 String stayDuration = userQueryEntity.getStayDuration();
 String ageRange = userQueryEntity.getAgeRange();

 String key = environmentType1 + "|" + climateType2 + "|" + accommodationType3 + "|" + activityType4 + "|" + stayDuration + "|" + ageRange;

 switch (key) {
 case "Playa|Caluroso|Relax y Bienestar|Hotel de Lujo|1-2 semanas|Menos de 30 años":
 this.destinoAmerica = "Playa del Carmen";
 this.destinoEuropa = "Santorini";
 break;
 case "Playa|Caluroso|Cultura y Museos|Airbnb|Menos de una semana|Menos de 30 años":
 this.destinoAmerica = "Cartagena";
 this.destinoEuropa = "Barcelona";
 break;
 case "Playa|Templado|Cultura y Museos|Hotel de Lujo|1-2 semanas|30-50 años":
 this.destinoAmerica = "Rio de Janeiro";
 this.destinoEuropa = "Lisboa";
 break;
 case "Montaña|Frío|Deportes y Aventuras|Hostal o Albergue|1-2 semanas|Menos de 30 años":
 this.destinoAmerica = "Bariloche";
 this.destinoEuropa = "Interlaken";
 break;
 default:
 this.destinoAmerica = "Destino desconocido en América";
 this.destinoEuropa = "Destino desconocido en Europa";
 break;
 }
 }
 */




