package ru.ncedu.java.tasks;

import java.util.ArrayList;

/**
 * Created by Sir Nightmare on 08/03/16.
 * Class for checking
 */
public class Main {
    public static void main(String[] args) {
        String poem = "Я памятник себе воздвиг нерукотворный,\n" +
                "К нему не /|!@#$%^&*()_+-=::;;<>зарастет народная тропа,\n" +
                "Вознесся выше он главою непокорной\n" +
                "Александрийс\\кого столпа?\n" +

                "Нет, весь я не умру — душа в заветной лире\n" +
                "Мой прах переживет и тленья убежит —\n" +
                "И славен буду я, доколь в подлунном мире\n" +
                "Жив будет хоть один пиит.\n" +

                "Слух обо мне пойдет по всей Руси великой,\n" +
                "И назовет меня всяк сущий в ней язык,\n" +
                "И гордый внук славян, и финн, и ныне дикой\n" +
                "Тунгус, и друг степей калмык.\n" +

                "И долго буду тем любезен я народу,\n" +
                "Что чувства добрые я лирой пробуждал,\n" +
                "Что в мой жестокий век восславил я свободу\n" +
                "И милость к падшим призывал.\n" +

                "Веленью божию, о муза, будь послушна;\n" +
                "Обиды не страшась, не требуя венца,\n" +
                "Хвалу и клевету приемли равнодушно\n" +
                "И не оспоривай глупца.\n";


        WordCounter lol = new WordCounterImpl();
        lol.setText(poem);
        lol.getWordCounts();

//        for (Map.Entry entry : numberOfWords.entrySet()) {
//            System.out.println("Key: " + entry.getKey() + " Value: "
//                    + entry.getValue());
//        }

    }
}
