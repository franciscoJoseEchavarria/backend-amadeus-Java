package com.eafit.retoamadeus.logic;

import com.eafit.retoamadeus.models.HotelModel;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.List;

/*Logica para encontrar las recomendaciones de Hoteles
 *Esta clase esta planteada para tener dos respuesta por cada destino que se desee visitar
 * esta tien esu clase principal en HotelssModel y HotelsEntity
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
                            .img("solyMar.jpg")
                            .description("Hotel con vistas al mar, piscina y restaurante gourmet")
                            .build(),
                    HotelModel.builder()
                            .name("Hotel Paraíso Tropical")
                            .img("paraisoTropical.jpg")
                            .description("Hotel de lujo con acceso directo a la playa y actividades acuáticas")
                            .build()
            )),
            Map.entry("Santorini", List.of(
                    HotelModel.builder()
                            .name("Hotel Aegeo Blue")
                            .img("aegeoBlue.jpg")
                            .description("Hotel con vistas panorámicas del mar Egeo y diseño tradicional")
                            .build(),
                    HotelModel.builder()
                            .name("Hotel Sunset Dreams")
                            .img("sunsetDreams.jpg")
                            .description("Hotel romántico ideal para disfrutar de atardeceres inolvidables")
                            .build()
            )),
            Map.entry("Cartagena", List.of(
                    HotelModel.builder()
                            .name("Hotel Colonial")
                            .img("colonial.jpg")
                            .description("Hotel con arquitectura colonial y piscina en la azotea")
                            .build(),
                    HotelModel.builder()
                            .name("Hotel Caribe")
                            .img("caribe.jpg")
                            .description("Hotel de lujo con playa privada y spa")
                            .build()
            )),
            Map.entry("Rio de Janeiro", List.of(
                    HotelModel.builder()
                            .name("Hotel Copacabana Palace")
                            .img("copacabanaPalace.jpg")
                            .description("Hotel de lujo con vistas a la playa de Copacabana")
                            .build(),
                    HotelModel.builder()
                            .name("Hotel Maravilha")
                            .img("maravilha.jpg")
                            .description("Hotel boutique con piscina en la azotea y vistas al Cristo Redentor")
                            .build()
            )),
            Map.entry("Bariloche", List.of(
                    HotelModel.builder()
                            .name("Hotel Llao Llao")
                            .img("llaoLlao.jpg")
                            .description("Hotel de montaña con campo de golf y spa")
                            .build(),
                    HotelModel.builder()
                            .name("Hotel Cacique Inacayal")
                            .img("caciqueInacayal.jpg")
                            .description("Hotel con vistas al lago Nahuel Huapi y piscina climatizada")
                            .build()
            )),
            Map.entry("Cusco", List.of(
                    HotelModel.builder()
                            .name("Hotel Palacio del Inka")
                            .img("palacioDelInka.jpg")
                            .description("Hotel de lujo con arquitectura colonial y spa")
                            .build(),
                    HotelModel.builder()
                            .name("Hotel Aranwa")
                            .img("aranwa.jpg")
                            .description("Hotel boutique con vistas a la Plaza de Armas y restaurante gourmet")
                            .build()
            )),
            Map.entry("Banff", List.of(
                    HotelModel.builder()
                            .name("Hotel Fairmont Banff Springs")
                            .img("fairmontBanffSprings.jpg")
                            .description("Hotel de lujo con campo de golf y spa")
                            .build(),
                    HotelModel.builder()
                            .name("Hotel Rimrock Resort")
                            .img("rimrockResort.jpg")
                            .description("Hotel con vistas a las Montañas Rocosas y piscina climatizada")
                            .build()
            )),
            Map.entry("Nueva York", List.of(
                    HotelModel.builder()
                            .name("Hotel The Plaza")
                            .img("thePlaza.jpg")
                            .description("Hotel de lujo con vistas a Central Park y restaurante gourmet")
                            .build(),
                    HotelModel.builder()
                            .name("Hotel The St. Regis")
                            .img("theStRegis.jpg")
                            .description("Hotel boutique con spa y servicio de mayordomo")
                            .build()
            )),
            Map.entry("Barcelona", List.of(
                    HotelModel.builder()
                            .name("Hotel W Barcelona")
                            .img("wBarcelona.jpg")
                            .description("Hotel de lujo con vistas al mar y piscina en la azotea")
                            .build(),
                    HotelModel.builder()
                            .name("Hotel Casa Fuster")
                            .img("casaFuster.jpg")
                            .description("Hotel boutique con arquitectura modernista y restaurante gourmet")
                            .build()
            )),
            Map.entry("Lisboa", List.of(
                    HotelModel.builder()
                            .name("Hotel Four Seasons Hotel Ritz")
                            .img("fourSeasonsHotelRitz.jpg")
                            .description("Hotel de lujo con vistas al Parque Eduardo VII y spa")
                            .build(),
                    HotelModel.builder()
                            .name("Hotel Olissippo Lapa Palace")
                            .img("olissippoLapaPalace.jpg")
                            .description("Hotel boutique con jardines tropicales y piscina climatizada")
                            .build()
            )),
            Map.entry("Interlaken", List.of(
                    HotelModel.builder()
                            .name("Hotel Victoria Jungfrau Grand Hotel & Spa")
                            .img("victoriaJungfrauGrandHotel&Spa.jpg")
                            .description("Hotel de lujo con vistas a las montañas y spa")
                            .build(),
                    HotelModel.builder()
                            .name("Hotel Lindner Grand Hotel Beau Rivage")
                            .img("lindnerGrandHotelBeauRivage.jpg")
                            .description("Hotel boutique con vistas al lago Thun y restaurante gourmet")
                            .build()
            )),
            Map.entry("Granada", List.of(
                    HotelModel.builder()
                            .name("Hotel Alhambra Palace")
                            .img("alhambraPalace.jpg")
                            .description("Hotel de lujo con vistas a la Alhambra y jardines")
                            .build(),
                    HotelModel.builder()
                            .name("Hotel Palacio de Santa Inés")
                            .img("palacioDeSantaInés.jpg")
                            .description("Hotel boutique con arquitectura morisca y patio andaluz")
                            .build()
            )),
            Map.entry("Zermatt", List.of(
                    HotelModel.builder()
                            .name("Hotel Mont Cervin Palace")
                            .img("montCervinPalace.jpg")
                            .description("Hotel de lujo con vistas al Matterhorn y spa")
                            .build(),
                    HotelModel.builder()
                            .name("Hotel Riffelalp Resort 2222m")
                            .img("riffelalpResort2222m.jpg")
                            .description("Hotel boutique con vistas a las montañas y restaurante gourmet")
                            .build()
            )),
            Map.entry("París", List.of(
                    HotelModel.builder()
                            .name("Hotel Le Meurice")
                            .img("leMeurice.jpg")
                            .description("Hotel de lujo con vistas al Jardín de las Tullerías y spa")
                            .build(),
                    HotelModel.builder()
                            .name("Hotel Le Bristol")
                            .img("leBristol.jpg")
                            .description("Hotel boutique con jardines privados y restaurante gourmet")
                            .build()
            )),
            Map.entry("Bora Bora", List.of(
                    HotelModel.builder()
                            .name("Hotel Four Seasons Resort Bora Bora")
                            .img("fourSeasonsResortBoraBora.jpg")
                            .description("Hotel de lujo con bungalows sobre el agua y spa")
                            .build(),
                    HotelModel.builder()
                            .name("Hotel The St. Regis Bora Bora Resort")
                            .img("theStRegisBoraBoraResort.jpg")
                            .description("Hotel boutique con vistas al monte Otemanu y restaurante gourmet")
                            .build()
            )),
            Map.entry("Dubaí", List.of(
                    HotelModel.builder()
                            .name("Hotel Burj Al Arab Jumeirah")
                            .img("burjAlArabJumeirah.jpg")
                            .description("Hotel de lujo con vistas al Golfo Pérsico y spa")
                            .build(),
                    HotelModel.builder()
                            .name("Hotel Jumeirah Al Qasr")
                            .img("jumeirahAlQasr.jpg")
                            .description("Hotel boutique con playa privada y restaurante gourmet")
                            .build()
            ))
    );

    public List<HotelModel> getHotelRecommendations(String nombreDestino) {
        return hotelRecommendations.getOrDefault(nombreDestino, List.of());
    }
}