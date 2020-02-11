package by.it.dolgiy.jd01_06;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    private static char[] gl = {'а', 'у', 'о', 'ы', 'и', 'э', 'я', 'ю', 'ё', 'е', 'А', 'У', 'О', 'Ы', 'И', 'Э', 'Я',
            'Ю', 'Ё', 'Е'};
    private static char[] sog = {'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'к', 'л', 'м', 'н', 'п', 'р', 'с', 'т', 'ф',
            'х', 'ц', 'ч', 'ш', 'щ', 'Б', 'В', 'Г', 'Д', 'Ж', 'З', 'Й', 'К', 'Л', 'М', 'Н', 'П', 'Р', 'С', 'Т',
            'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ'};

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()){
            String word = matcher.group();
            char[] w = word.toCharArray();
            char start = w[0];
            char end = w[w.length-1];
            for (int j = 0; j <= sog.length - 1; j++) {
                if (start == end) {
                    break;
                    }
                if (start == sog[j]) {
                    for (int k = 0; k <= gl.length - 1; k++) {
                        if (end == gl[k]) {
                                System.out.println(word);
                        }
                    }
                }
            }
        }
    }
}
