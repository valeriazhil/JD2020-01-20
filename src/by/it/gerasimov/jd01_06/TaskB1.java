package by.it.gerasimov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]{2,}");
        Matcher m = p.matcher(Poem.text);
        while (m.find()) {
            if (isRightWord(m.group())) {
                System.out.println(m.group());
            }
        }
    }

    private static boolean isRightWord(CharSequence str) {
        return !isVowelLetter(str.charAt(0)) && isVowelLetter(str.charAt(str.length() - 1));
    }

    private static boolean isVowelLetter(char c) {
        char[] vowels = {'а', 'е', 'ё', 'и', 'о', 'у', 'ы', 'э' ,'ю' ,'я'};
        for (char vowel : vowels) {
            if (Character.toLowerCase(c) == vowel) {
                return true;
            }
        }
        return false;
    }
}
