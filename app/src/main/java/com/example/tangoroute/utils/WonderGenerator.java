package com.example.tangoroute.utils;

import android.app.Application;

import com.example.tangoroute.models.Coordinates;
import com.example.tangoroute.models.Location;
import com.example.tangoroute.models.Wonder;
import com.example.tangoroute.persistence.WonderRepository;

import java.util.ArrayList;
import java.util.List;

public class WonderGenerator {

    public static void insertAll(Application application) {
        List<Wonder> wonders = new ArrayList<>();
        //CHICHEN ITZA
        Coordinates coordinates = new Coordinates(20.6842849, -88.5677826);
        wonders.add(Wonder.builder()
                .name("Chichén Itza")
                .location(new Location("Chichén Itza", "Mexico", coordinates))
                .description("Esta antigua ciudad maya es uno de los centros arqueológicos " +
                        "más importantes de la península de Yucatán, en México. Su nombre en maya " +
                        "significa 'Boca del pozo de los itzaes', ya que hace referencia al cenote " +
                        "sagrado que, según las creencias de la época, servía de entrada al inframundo. " +
                        "En él se veneraba a Chaac, el dios de la lluvia. Chichén Itza fue fundada " +
                        "en el año 525 d.C y su monumento más importante es la pirámide dedicada al " +
                        "dios Kukulcán, una de las fortalezas mejor conservadas del lugar e imagen " +
                        "de las postales de la zona. La belleza y el valor histórico de Chichén Itza " +
                        "ha hecho que en 1988 fuese declarado patrimonio de la humanidad por la UNESCO.")
                .build());
        //EL COLISEO
        coordinates = new Coordinates(41.8902102, 12.4922309);
        wonders.add(Wonder.builder()
                .name("El Coliseo")
                .location(new Location("Roma", "Italia", coordinates))
                .description("Este anfiteatro es uno de los tesoros que el Imperio romano ha dejado " +
                        "como herencia a la Ciudad Eterna. También fue el más grande jamás construido. " +
                        "Su nombre original era anfiteatro Flavio, ya que fue levantado en el I d.C " +
                        "durante la dinastía Flavia. Originariamente, en él se organizaban " +
                        "luchas de gladiadores, además de otros espectáculos. Estuvo en funcionamiento " +
                        "durante más de 500 años y contaba con una capacidad de unos 50 mil espectadores. " +
                        "En 1980 fue declarado patrimonio de la humanidad y, a pesar de sus " +
                        "desperfectos tras varios terremotos, hoy en día el Coliseo sigue siendo el " +
                        "monumento más importante de Roma, y único punto de la lista de las 7 " +
                        "maravillas del mundo de Europa.")
                .build());
        //EL CRISTO REDENTOR
        coordinates = new Coordinates(-22.951916, -43.2104872);
        wonders.add(Wonder.builder()
                .name("Cristo Redentor")
                .location(new Location("Río de Janeiro", "Brasil", coordinates))
                .description("El Cristo Redentor es una de las estatuas más famosas del mundo, " +
                        "y también una de las más grandes. Con sus 30 metros de altitud, " +
                        "Jesús de Nazaret acoge con los brazos abiertos la ciudad brasileña de " +
                        "Río de Janeiro, en Brasil. Lo hace desde el cerro del Concorvado, a algo más " +
                        "de 700 metros sobre el nivel del mar desde donde se obtienen unas " +
                        "espectaculares vistas. Fue levantada en 1931 y se dice que se tardaron más " +
                        "de cinco años en construirla. Hoy en día es un emblema de Brasil, lugar de " +
                        "peregrinación e icono de los artistas brasileños, puesto que este es el " +
                        "único monumento de las 7 maravillas considerado Art Decó.")
                .build());
        //LA GRAN MURALLA
        coordinates = new Coordinates(40.4319077, 116.5703749);
        wonders.add(Wonder.builder()
                .name("Gran Muralla China")
                .location(new Location("", "China", coordinates))
                .description("Es la obra arquitectónica más importante de China, una antigua fortaleza " +
                        "que a los chinos les sirvió como defensa ante los posibles ataques mongoles. " +
                        "En sus orígenes llegó a medir más de 21 mil kilómetros a lo largo del sur " +
                        "de Mongolia, desde la frontera con Corea hasta el desierto de Gobi. " +
                        "Durante su construcción millones de obreros perdieron la vida. Éstos fueron " +
                        "enterrados en sus inmediaciones, por lo que esta gran muralla está considerada " +
                        "como el mayor cementerio del mundo. En 1987 fue declarada como patrimonio " +
                        "de la humanidad.")
                .build());
        //MACHU PICCHU
        coordinates = new Coordinates(-13.1631412, -72.5449629);
        wonders.add(Wonder.builder()
                .name("Machu Picchu")
                .location(new Location("Machu Picchu", "Perú", coordinates))
                .description("Una de las joyas andinas mejor conservadas del imperio inca. Data del " +
                        "siglo XV y se cree que sirvió como antiguo santuario y como residencia del " +
                        "soberano del imperio. Fue levantada sobre un premonitorio rocoso, entre las " +
                        "montañas de Machu Picchu y Huayna Picchu, a unos 2.500 metros sobre el " +
                        "nivel del mar. Su latitud, de hecho, hace que muchos viajeros sufran el mal " +
                        "de altura según van ascendiendo desde Cuzco para visitar la más emblemática " +
                        "de las 7 Maravillas del mundo.")
                .build());
        //PETRA
        coordinates = new Coordinates(30.3284544, 35.4443622);
        wonders.add(Wonder.builder()
                .name("Petra")
                .location(new Location("Petra", "Jordania", coordinates))
                .description("La capital del antiguo reino nabateo está esculpida sobre la roca. " +
                        "Es uno de los enclaves arqueológicos más importantes de Jordania, y uno de " +
                        "los más visitados del país. Fue fundada en el siglo VIII a.C y era una de " +
                        "las localidades de paso de la popular Ruta de la Seda. El cambio de la vía " +
                        "comercial hizo que la ciudad fuese abandonada, hasta que un explorador suizo " +
                        "la redescubrió en Occidente. En esta maravilla del mundo moderno podrás " +
                        "sentirte Indiana Jones delante del Tesoro, que así se llama la primera " +
                        "construcción que te encuentras al adentrarte en el desfiladero de 1,5 km de " +
                        "largo. Toda la ciudad escondida de Petra fue declarada patrimonio de la " +
                        "humanidad en 1985.")
                .build());
        //TAJ MAHAL
        coordinates = new Coordinates(27.1750151, 78.0421552);
        wonders.add(Wonder.builder()
                .name("Taj Mahal")
                .location(new Location("Agra", "India", coordinates))
                .description("El Taj Mahal es, posiblemente, uno de los edificios más románticos del " +
                        "mundo. Fue construido a mediados del siglo XVII por el emperador Shah Jahan " +
                        "como mausoleo para enterrar a su difunta esposa, Arjumand Bano Begum, " +
                        "más conocida como Mumtaz Mahal. Ella perdió la vida en su decimocuarto parto " +
                        "y se dice que, el emperador estaba tan enamorado, que ordenó construir el " +
                        "mausoleo más bello y grandioso en su honor. A su muerte, uno de los hijos " +
                        "de Jahan le dio sepultura justo al lado de su amada. Según la leyenda, " +
                        "cuando el Taj Mahal estuvo finalizado se ordenó cortar las manos de todos " +
                        "los obreros que trabajaron en él. Se quería evitar que nunca más pudiesen " +
                        "construir un edificio de tal belleza. Desde 1983 es patrimonio de la humanidad.")
                .build());
        for (Wonder wonder : wonders) {
            WonderRepository.getInstance(application).insert(wonder);
        }
    }
}
