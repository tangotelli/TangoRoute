package com.example.tangoroute.utils;

import android.app.Application;

import com.example.tangoroute.models.Question;
import com.example.tangoroute.persistence.QuestionRepository;

import java.util.ArrayList;
import java.util.List;

public class QuestionGenerator {

    public static void insertAll(Application application) {
        QuestionRepository.getInstance(application).deleteAll();
        List<Question> questions = new ArrayList<>();
        //CHICHEN ITZA
        questionsChichenItza(questions);
        //EL COLISEO
        questionsColiseo(questions);
        //CRISTO REDENTOR
        questionsCristoRedentor(questions);
        //GRAN MURALLA CHINA
        questionsGranMuralla(questions);
        //MACHU PICCHU
        questionsMachuPicchu(questions);
        //PETRA
        questionsPetra(questions);
        //TAJ MAHAL
        questionsTajMahal(questions);
        for (Question question : questions) {
            QuestionRepository.getInstance(application).insert(question);
        }
    }

    private static void questionsChichenItza(List<Question> questions) {
        String wonderName = "Chichén Itza";
        questions.add(Question.builder()
                    .wonderName(wonderName)
                    .statement("¿Cómo se llama el edificio más célebre de Chichen Itzá?")
                    .answerOptions(new String[]{"Iglesia", "Templo de Kukulcán", "Pirámide de Itza"})
                    .correctAnswer(1)
                    .points(25)
                    .build());
        questions.add(Question.builder()
                .wonderName(wonderName)
                .statement("¿En qué año se convierte en Patrimonio de la Humanidad según la UNESCO?")
                .answerOptions(new String[]{"1988", "2007", "1995"})
                .correctAnswer(0)
                .points(25)
                .build());
        questions.add(Question.builder()
                .wonderName(wonderName)
                .statement("¿Qué dios representa Kukulcán?")
                .answerOptions(new String[]{"Ra", "Itzámna", "Quetzálcoatl"})
                .correctAnswer(2)
                .points(25)
                .build());
        questions.add(Question.builder()
                .wonderName(wonderName)
                .statement("¿En qué año aproximadamente se funda Chichen Itzá?")
                .answerOptions(new String[]{"200 A.C", "250 D.C", "100 D.C"})
                .correctAnswer(1)
                .points(25)
                .build());
    }

    private static void questionsColiseo(List<Question> questions) {
        String wonderName = "El Coliseo";
        questions.add(Question.builder()
                .wonderName(wonderName)
                .statement("¿Quién inició la construcción del Coliseo?")
                .answerOptions(new String[]{"Tito", "Vespasiano", "Julio César"})
                .correctAnswer(1)
                .points(25)
                .build());
        questions.add(Question.builder()
                .wonderName(wonderName)
                .statement("¿Cuánto tiempo duró la inaguración del Coliseo?")
                .answerOptions(new String[]{"1 mes", "100 días", "1 año"})
                .correctAnswer(1)
                .points(25)
                .build());
        questions.add(Question.builder()
                .wonderName(wonderName)
                .statement("¿Con qué otro nombre se conoce al Coliseo?")
                .answerOptions(new String[]{"Anfiteatro de Tito", "Coliseo Flavio", "Anfiteatro FLavio"})
                .correctAnswer(2)
                .points(25)
                .build());
        questions.add(Question.builder()
                .wonderName(wonderName)
                .statement("¿En qué fecha se realiza una viacrucis encabezado por el Papa?")
                .answerOptions(new String[]{"Nochebuena", "Domingo de Resurrección", "Viernes santo"})
                .correctAnswer(2)
                .points(25)
                .build());
    }

    private static void questionsCristoRedentor(List<Question> questions) {
        String wonderName = "Cristo Redentor";
        questions.add(Question.builder()
                .wonderName(wonderName)
                .statement("¿En qué ciudad se encuentra esta estatua?")
                .answerOptions(new String[]{"Río de Janeiro", "Sao Paulo", "Brasília"})
                .correctAnswer(0)
                .points(25)
                .build());
        questions.add(Question.builder()
                .wonderName(wonderName)
                .statement("¿Con qué otro nombre se conoce a este monumento?")
                .answerOptions(new String[]{"Cristo de Río", "Cristo del Corcovado", "Jesús Redentor"})
                .correctAnswer(1)
                .points(25)
                .build());
        questions.add(Question.builder()
                .wonderName(wonderName)
                .statement("¿Cuánto mide la estatua en total?")
                .answerOptions(new String[]{"100 metros", "46 metros", "38 metros"})
                .correctAnswer(1)
                .points(25)
                .build());
        questions.add(Question.builder()
                .wonderName(wonderName)
                .statement("¿En qué año se inaugura el Cristo del Corcovado?")
                .answerOptions(new String[]{"1957", "1931", "2002"})
                .correctAnswer(1)
                .points(25)
                .build());
    }

    private static void questionsGranMuralla(List<Question> questions) {
        String wonderName = "Gran Muralla China";
        questions.add(Question.builder()
                .wonderName(wonderName)
                .statement("¿Cuánto se calcula que mide la gran muralla contando sus ramificaciones?")
                .answerOptions(new String[]{"30000 km", "15850 km", "21200 km"})
                .correctAnswer(2)
                .points(25)
                .build());
        questions.add(Question.builder()
                .wonderName(wonderName)
                .statement("¿Quién afirmó falsamente por primera vez que la muralla se veía desde el espacio?")
                .answerOptions(new String[]{"Neil Armstrong", "Richard Haliburton", "Mao Tse Tung"})
                .correctAnswer(1)
                .points(25)
                .build());
        questions.add(Question.builder()
                .wonderName(wonderName)
                .statement("¿Cuándo fue declarada patrimonio de la humanidad de la UNESCO?")
                .answerOptions(new String[]{"1987", "1988", "1998"})
                .correctAnswer(0)
                .points(25)
                .build());
        questions.add(Question.builder()
                .wonderName(wonderName)
                .statement("¿Cuándo se estima que se inició la construcción de la Gran Muralla?")
                .answerOptions(new String[]{"Siglo I A.C", "Siglo V A.C", "Siglo VII A.C"})
                .correctAnswer(1)
                .points(25)
                .build());
    }

    private static void questionsMachuPicchu(List<Question> questions) {
        String wonderName = "Machu Picchu";
        questions.add(Question.builder()
                .wonderName(wonderName)
                .statement("¿A qué altura se ubica esta maravilla?")
                .answerOptions(new String[]{"4550 metros", "2430 metros", "3000 metros"})
                .correctAnswer(1)
                .points(25)
                .build());
        questions.add(Question.builder()
                .wonderName(wonderName)
                .statement("¿Cómo se traduce el nombre del sitio?")
                .answerOptions(new String[]{"Montaña Vieja", "Macizo Picudo", "Monte Sagrado"})
                .correctAnswer(0)
                .points(25)
                .build());
        questions.add(Question.builder()
                .wonderName(wonderName)
                .statement("¿Que civilización construyó esta ciudad?")
                .answerOptions(new String[]{"Inca", "Cuzca", "Quechua"})
                .correctAnswer(0)
                .points(25)
                .build());
        questions.add(Question.builder()
                .wonderName(wonderName)
                .statement("¿Cómo se llama la cordillera en que se ubica esta ciudad?")
                .answerOptions(new String[]{"Montes Picchu", "Cordillera centroperuana", "Los Andes"})
                .correctAnswer(2)
                .points(25)
                .build());
    }

    private static void questionsPetra(List<Question> questions) {
        String wonderName = "Petra";
        questions.add(Question.builder()
                .wonderName(wonderName)
                .statement("¿De qué reino era capital esta ciudad?")
                .answerOptions(new String[]{"Egipcio", "Mesopotámico", "Nabateo"})
                .correctAnswer(2)
                .points(25)
                .build());
        questions.add(Question.builder()
                .wonderName(wonderName)
                .statement("¿Quién descubrió para el mundo occidental este enclave?")
                .answerOptions(new String[]{"Lawrence de Arabia", "Howard Carter", "Jean Louis Burckhardt"})
                .correctAnswer(2)
                .points(25)
                .build());
        questions.add(Question.builder()
                .wonderName(wonderName)
                .statement("¿Cuál es la característica que hace tan célebre esta ciudad?")
                .answerOptions(new String[]{"Las grandes pirámides", "Edificios labrados en la roca",
                        "Primeros rascacielos de la historia"})
                .correctAnswer(1)
                .points(25)
                .build());
        questions.add(Question.builder()
                .wonderName(wonderName)
                .statement("¿Cómo llamaban sus pobladores a la ciudad?")
                .answerOptions(new String[]{"Raqma", "Petra", "Al Batra"})
                .correctAnswer(0)
                .points(25)
                .build());
    }

    private static void questionsTajMahal(List<Question> questions) {
        String wonderName = "Taj Mahal";
        questions.add(Question.builder()
                .wonderName(wonderName)
                .statement("¿En honor de quién se construyó este monumento?")
                .answerOptions(new String[]{"El emperador Shah Jahan", "Su esposa Mumtaz Mahal",
                        "Su padre Jahangir"})
                .correctAnswer(1)
                .points(25)
                .build());
        questions.add(Question.builder()
                .wonderName(wonderName)
                .statement("¿En qué año se inició la construcción del Taj Mahal?")
                .answerOptions(new String[]{"1492", "1539", "1632"})
                .correctAnswer(2)
                .points(25)
                .build());
        questions.add(Question.builder()
                .wonderName(wonderName)
                .statement("¿Cuál es el tamaño de la estructura?")
                .answerOptions(new String[]{"17 hectáreas", "20 hectáreas", "22 hectáreas"})
                .correctAnswer(0)
                .points(25)
                .build());
        questions.add(Question.builder()
                .wonderName(wonderName)
                .statement("¿Qué dice la leyenda que sucedió con los que trabajaron en su construcción?")
                .answerOptions(new String[]{"Fueron convertidos en nobles",
                        "Fueron encarcelados de por vida", "Fueron ejecutados"})
                .correctAnswer(2)
                .points(25)
                .build());
    }
}
