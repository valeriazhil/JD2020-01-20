package by.it.pkochubei.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        printWords();
    }

    private static void printWords() {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();

            bulkhead(word);
        }
    }

    private static void bulkhead(String word) {
        char[] vowels = {'а', 'А', 'о', 'О', 'е', 'Е', 'и', 'И', 'у', 'У', 'ю', 'Ю', 'ы', 'э', 'Э', 'ё', 'Ё', 'я', 'Я'};
        boolean startsConconant = true;
        for (char a : vowels) {
            if (word.charAt(0) == a) {
                startsConconant = false;
                break;
            }
        }
        boolean endsVowels = false;
        if (startsConconant) {
            for (char a : vowels) {
                if (word.charAt(word.length() - 1) == a) {
                    endsVowels = true;
                    break;
                }
            }
        }
        if (startsConconant && endsVowels) {
            System.out.println(word);
        }
    }
}
