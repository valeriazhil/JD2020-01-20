package by.it.anackij.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    private static String[] arrayVow = {"а, у, о, ы, и, э, я, ю, ё, е"};

    public static void main(String[] args) {
        Pattern patternWords = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = patternWords.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            wordWithStartVowelAndEndNonVowel(word);
        }
    }

    private static void wordWithStartVowelAndEndNonVowel(String word) {
        boolean startNonVowel = false;
        boolean endVowel = false;
        for (String symbol : arrayVow) {
            if (symbol.equals(word.charAt(0))) {
                break;
            } else {
                startNonVowel = true;
            }
        }
        for (String symbol : arrayVow) {
            if (symbol.equals(word.charAt(word.length() - 1))) {
                endVowel = true;
            }
        }
        if (startNonVowel && endVowel) {
            System.out.println(word);
        }
    }
}


