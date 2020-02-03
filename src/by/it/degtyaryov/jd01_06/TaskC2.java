package by.it.degtyaryov.jd01_06;

import java.util.Random;

public class TaskC2 {
    // TODO уточнить почему, если вынести рандом в члены класса,
    //  чтобы не создавать экземпляр в каждом методе, то в методах получаются разные слова

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(slow(Poem.text));
        System.out.printf("Slow. Выполнено за %d%n", (System.nanoTime() - startTime) / 1000);

        startTime = System.nanoTime();
        System.out.println(fast(Poem.text));
        System.out.printf("Fast. Выполнено за %d%n", (System.nanoTime() - startTime) / 1000);
    }

    /**
     * Медленный метод генерации строки, склеивающий слова String конкатенацией
     *
     * @param text текст для получения слов
     * @return строку, состоящую минимум из 100 000 случайных слов переданного текста
     * @author DEA
     */
    static String slow(String text) {
        String strResult = "";
        String[] words = text.split("[^а-яА-ЯёЁ]");
        Random random = new Random(40);
        while (strResult.length() < 100000) {
            strResult += words[random.nextInt(words.length)] + " ";
        }
        return strResult;
    }

    /**
     * Быстрый метод генерации строки, добавляющий слова с помощью StringBuilder
     *
     * @param text текст для получения слов
     * @return строку, состоящую минимум из 100 000 случайных слов переданного текста
     * @author DEA
     */
    static String fast(String text) {
        StringBuilder strResult = new StringBuilder(100000);
        String[] words = text.split("[^а-яА-ЯёЁ]");
        Random random = new Random(40);
        while (strResult.length() < 100000) {
            strResult.append(words[random.nextInt(words.length)]).append(' ');
        }
        return strResult.toString();
    }
}