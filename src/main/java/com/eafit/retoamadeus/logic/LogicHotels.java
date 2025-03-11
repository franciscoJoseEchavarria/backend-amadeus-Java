package com.eafit.retoamadeus.logic;

import com.eafit.retoamadeus.models.DetallesDestinosModel;
import com.eafit.retoamadeus.models.HotelModel;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.List;

/*Logica para encontrar las recomendaciones de Hoteles
 *Esta clase esta planteada para tener dos respuesta por cada destino que se desee visitar
 * esta tiene su clase principal en HotelssModel y HotelsEntity
 * en los servicios esta clase se debe transferir los datos diirectamente a DetailsVuelosaHotelsMappe,
 * en su servicio se maneja la lógica de la respuesta
 * se utiliza este mapper para los principios SOLID y separar responsabilidades
 * para que funciones debe tener respuestas de las ciudades de DetallesDestnioEntity
 */

@Component

public class LogicHotels {

    private final Map<String, List<HotelModel>> hotelRecommendations = Map.ofEntries(
            Map.entry("Playa del Carmen", List.of(
                    HotelModel.builder()
                            .name("Hotel Sol y Mar")
                            .img("/assets/img/hotels/solyMar.jpg")
                            .description("Hotel con vistas al mar, piscina y restaurante gourmet")
                            .build(),
                    HotelModel.builder()
                            .name("Hotel Paraíso Tropical")
                            .img("/assets/img/hotels/paraisoTropical.jpg")
                            .description("Hotel de lujo con acceso directo a la playa y actividades acuáticas")
                            .build()
            )),
            Map.entry("Santorini", List.of(
                    HotelModel.builder()
                            .name("Hotel Aegeo Blue")
                            .img("/assets/img/hotels/aegeoBlue.jpg")
                            .description("Hotel con vistas panorámicas del mar Egeo y diseño tradicional")
                            .build(),
                    HotelModel.builder()
                            .name("Hotel Sunset Dreams")
                            .img("/assets/img/hotels/sunsetDreams.jpg")
                            .description("Hotel romántico ideal para disfrutar de atardeceres inolvidables")
                            .build()
            )),
            Map.entry("Cartagena", List.of(
                    HotelModel.builder()
                            .name("Hotel Colonial")
                            .img("/assets/img/hotels/colonial.jpg")
                            .description("Hotel con arquitectura colonial y piscina en la azotea")
                            .build(),
                    HotelModel.builder()
                            .name("Hotel Caribe")
                            .img("/assets/img/hotels/caribe.jpg")
                            .description("Hotel de lujo con playa privada y spa")
                            .build()
            )),
            Map.entry("Rio de Janeiro", List.of(
                    HotelModel.builder()
                            .name("Hotel Copacabana Palace")
                            .img("/assets/img/hotels/copacabanaPalace.jpg")
                            .description("Hotel de lujo con vistas a la playa de Copacabana")
                            .build(),
                    HotelModel.builder()
                            .name("Hotel Maravilha")
                            .img("/assets/img/hotels/maravilha.jpg")
                            .description("Hotel boutique con piscina en la azotea y vistas al Cristo Redentor")
                            .build()
            )),
            Map.entry("Bariloche", List.of(
                    HotelModel.builder()
                            .name("Hotel Llao Llao")
                            .img("/assets/img/hotels/llaoLlao.jpg")
                            .description("Hotel de montaña con campo de golf y spa")
                            .build(),
                    HotelModel.builder()
                            .name("Hotel Cacique Inacayal")
                            .img("/assets/img/hotels/caciqueInacayal.jpg")
                            .description("Hotel con vistas al lago Nahuel Huapi y piscina climatizada")
                            .build()
            )),
            Map.entry("Cusco", List.of(
                    HotelModel.builder()
                            .name("Hotel Palacio del Inka")
                            .img("/assets/img/hotels/palacioDelInka.jpg")
                            .description("Hotel de lujo con arquitectura colonial y spa")
                            .build(),
                    HotelModel.builder()
                            .name("Hotel Aranwa")
                            .img("/assets/img/hotels/aranwa.jpg")
                            .description("Hotel boutique con vistas a la Plaza de Armas y restaurante gourmet")
                            .build()
            )),
            Map.entry("Banff", List.of(
                    HotelModel.builder()
                            .name("Hotel Fairmont Banff Springs")
                            .img("/assets/img/hotels/fairmontBanffSprings.jpg")
                            .description("Hotel de lujo con campo de golf y spa")
                            .build(),
                    HotelModel.builder()
                            .name("Hotel Rimrock Resort")
                            .img("/assets/img/hotels/rimrockResort.jpg")
                            .description("Hotel con vistas a las Montañas Rocosas y piscina climatizada")
                            .build()
            )),
            Map.entry("Nueva York", List.of(
                    HotelModel.builder()
                            .name("Hotel The Plaza")
                            .img("/assets/img/hotels/thePlaza.jpg")
                            .description("Hotel de lujo con vistas a Central Park y restaurante gourmet")
                            .build(),
                    HotelModel.builder()
                            .name("Hotel The St. Regis")
                            .img("/assets/img/hotels/theStRegis.jpg")
                            .description("Hotel boutique con spa y servicio de mayordomo")
                            .build()
            )),
            Map.entry("Barcelona", List.of(
                    HotelModel.builder()
                            .name("Hotel W Barcelona")
                            .img("/assets/img/hotels/wBarcelona.jpg")
                            .description("Hotel de lujo con vistas al mar y piscina en la azotea")
                            .build(),
                    HotelModel.builder()
                            .name("Hotel Casa Fuster")
                            .img("/assets/img/hotels/casaFuster.jpg")
                            .description("Hotel boutique con arquitectura modernista y restaurante gourmet")
                            .build()
            )),
            Map.entry("Lisboa", List.of(
                    HotelModel.builder()
                            .name("Hotel Four Seasons Hotel Ritz")
                            .img("/assets/img/hotels/fourSeasonsHotelRitz.jpg")
                            .description("Hotel de lujo con vistas al Parque Eduardo VII y spa")
                            .build(),
                    HotelModel.builder()
                            .name("Hotel Olissippo Lapa Palace")
                            .img("/assets/img/hotels/olissippoLapaPalace.jpg")
                            .description("Hotel boutique con jardines tropicales y piscina climatizada")
                            .build()
            )),
            Map.entry("Interlaken", List.of(
                    HotelModel.builder()
                            .name("Hotel Victoria Jungfrau Grand Hotel & Spa")
                            .img("/assets/img/hotels/victoriaJungfrauGrandHotel&Spa.jpg")
                            .description("Hotel de lujo con vistas a las montañas y spa")
                            .build(),
                    HotelModel.builder()
                            .name("Hotel Lindner Grand Hotel Beau Rivage")
                            .img("/assets/img/hotels/lindnerGrandHotelBeauRivage.jpg")
                            .description("Hotel boutique con vistas al lago Thun y restaurante gourmet")
                            .build()
            )),
            Map.entry("Granada", List.of(
                    HotelModel.builder()
                            .name("Hotel Alhambra Palace")
                            .img("/assets/img/hotels/alhambraPalace.jpg")
                            .description("Hotel de lujo con vistas a la Alhambra y jardines")
                            .build(),
                    HotelModel.builder()
                            .name("Hotel Palacio de Santa Inés")
                            .img("/assets/img/hotels/palacioDeSantaInés.jpg")
                            .description("Hotel boutique con arquitectura morisca y patio andaluz")
                            .build()
            )),
            Map.entry("Zermatt", List.of(
                    HotelModel.builder()
                            .name("Hotel Mont Cervin Palace")
                            .img("/assets/img/hotels/montCervinPalace.jpg")
                            .description("Hotel de lujo con vistas al Matterhorn y spa")
                            .build(),
                    HotelModel.builder()
                            .name("Hotel Riffelalp Resort 2222m")
                            .img("/assets/img/hotels/riffelalpResort2222m.jpg")
                            .description("Hotel boutique con vistas a las montañas y restaurante gourmet")
                            .build()
            )),
            Map.entry("París", List.of(
                    HotelModel.builder()
                            .name("Hotel Le Meurice")
                            .img("/assets/img/hotels/leMeurice.jpg")
                            .description("Hotel de lujo con vistas al Jardín de las Tullerías y spa")
                            .build(),
                    HotelModel.builder()
                            .name("Hotel Le Bristol")
                            .img("/assets/img/hotels/leBristol.jpg")
                            .description("Hotel boutique con jardines privados y restaurante gourmet")
                            .build()
            )),
            Map.entry("Bora Bora", List.of(
                    HotelModel.builder()
                            .name("Hotel Four Seasons Resort Bora Bora")
                            .img("/assets/img/hotels/fourSeasonsResortBoraBora.jpg")
                            .description("Hotel de lujo con bungalows sobre el agua y spa")
                            .build(),
                    HotelModel.builder()
                            .name("Hotel The St. Regis Bora Bora Resort")
                            .img("/assets/img/hotels/theStRegisBoraBoraResort.jpg")
                            .description("Hotel boutique con vistas al monte Otemanu y restaurante gourmet")
                            .build()
            )),
            Map.entry("Dubaí", List.of(
                    HotelModel.builder()
                            .name("Hotel Burj Al Arab Jumeirah")
                            .img("/assets/img/hotels/burjAlArabJumeirah.jpg")
                            .description("Hotel de lujo con vistas al Golfo Pérsico y spa")
                            .build(),
                    HotelModel.builder()
                            .name("Hotel Jumeirah Al Qasr")
                            .img("/assets/img/hotels/jumeirahAlQasr.jpg")
                            .description("Hotel boutique con playa privada y restaurante gourmet")
                            .build()
            ))
    );

    public List<HotelModel> getHotelRecommendations(String nombreDestino) {
        return hotelRecommendations.getOrDefault(nombreDestino, List.of());
    }
}