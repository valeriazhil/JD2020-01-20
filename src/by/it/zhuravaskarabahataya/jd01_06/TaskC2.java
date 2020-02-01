package by.it.zhuravaskarabahataya.jd01_06;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC2 {
    //.1) Сформировать и вернуть в методе String slow (String text)
    // из случайных слов исходного текста строку String
    // минимум в сто тысяч символов путем конкатенации.
    // Слова должны быть «склеены» через один пробел.
    // Затем: • В методе main: определить время работы метода slow
    // (удобно использовать System.nanoTime() или аналог);
    // вывести полученный текст и время работы метода slow в милисекундах на консоль.
    // • Ускорить процесс с StringBuilder (сделать новый метод String fast (String text),
    // ВАЖНО: его итог должен быть таким как в slow до буквы).
    // В main повторить  вывод.
    static String [] array = getRandomString();

    public static void main(String[] args) {
//        for (String a : array
//             ) {
//            System.out.println(a);
//        }
        long startSlow = System.currentTimeMillis();
        System.out.println(slow(Poem.text));
        System.out.println(System.currentTimeMillis() - startSlow);
        long startFast = System.currentTimeMillis();
        System.out.println(fast(Poem.text));
        System.out.println(System.currentTimeMillis() - startFast);

    }

    private static String slow(String text) {
        String result = "";
        for (int i = 0; i < 100_000; i++) {
            result = result.concat(array[i]);
            result = result.concat(" ");
        }
        return result;
    }

//    private static int getRandomNum(String [] array) {
//
//    }

    private static String[] getRandomString (){
        Random random = new Random();
        String[] array = getArrayOfStrings(Poem.text);

        String[] result = new String[100_000];
        for (int i = 0; i < result.length; i++) {
            int x= random.nextInt(array.length);
            result[i] = array[x];
        }
        return result;
    }

    private static String fast(String text){

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 100_000; i++) {
            result.append(array[i]);
            result.append(" ");
        }
        return result.toString();
    }

    private static String[] getArrayOfStrings(String text) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(text);
        int countOfWords = 0;
        while (matcher.find()) {
            countOfWords++;
        }
        String[] stringArray = new String[countOfWords];
        int counter = 0;
        Pattern pattern1 = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher1 = pattern1.matcher(text);
        while (matcher1.find()) {
            stringArray[counter++] = matcher1.group();
        }
//        for (String a: stringArray) {
//            System.out.println(a);
//        }
        return stringArray;
    }


}
