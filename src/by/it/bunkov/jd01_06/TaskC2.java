package by.it.bunkov.jd01_06;

import java.util.Random;

public class TaskC2 {

    static  String slow(String text) {
        String[] words = text.split("[^а-яА-ЯёЁ]+");
        Random r = new Random(0);
        String newText = "";
        while (newText.length() < 100000) {
            newText = newText.concat(words[r.nextInt(words.length - 1)] + " ");
        }
        return newText;
    }

    static String fast(String text) {
        String[] words = text.split("[^а-яА-ЯёЁ]+");
        Random r = new Random(0);
        StringBuilder newText = new StringBuilder();
        newText.ensureCapacity(100000);
        while (newText.length() < 100000) {
            newText.append(words[r.nextInt(words.length - 1)]);
            newText.append(" ");
        }
        return newText.toString();
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(slow(Poem.text));
        long endSlowTime = System.nanoTime();
        System.out.printf("%s%d\n", "Slow: ", (endSlowTime - startTime) / 1000000);
        System.out.println(fast(Poem.text));
        long endFastTime = System.nanoTime();
        System.out.printf("%s%d\n", "Fast: ", (endFastTime - endSlowTime) / 1000000);
    }
}





