package by.it.zhuravaskarabahataya.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    // Вывести в консоль все слова текста, начинающихся согласной и заканчивающихся гласной буквой
    // (нужно сделать для проверки этого условия приватный метод без regex).
    public static void main(String[] args) {
        printWords(Poem.text);
    }

    private static void printWords (String text){
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            String word = matcher.group();
            startsWithConconantEndsWithVowel(word);
        }
    }

    private static void startsWithConconantEndsWithVowel (String word){
        char[] vowels = {'а','А', 'о','О','е','Е','и', 'И', 'я', 'Я', 'у', 'У', 'ю' ,'Ю','ы','э','Э','ё','Ё'};
        boolean startsWithConconant = true;
        for (char a: vowels) {
            if (word.charAt(0) == a){
                startsWithConconant = false;
                break;
            }
        }
        boolean endsWithVowels = false;
        if (startsWithConconant){
            for (char a: vowels) {
                if (word.charAt(word.length() - 1) == a){
                    endsWithVowels = true;
                    break;
                }
            }
        }
        if (startsWithConconant && endsWithVowels){
            System.out.println(word);
        }
    }
}
