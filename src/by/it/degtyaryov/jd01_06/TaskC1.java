package by.it.degtyaryov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {

    public static void main(String[] args) {
        String[] lines = Poem.text.split("\n");
        int maxLength = findMaxLength(lines);
        alignByWidth(lines, maxLength);
        for (String line : lines) {
            System.out.println(line);
        }
    }

    /**
     * @param array массив строк для поиска
     * @return размер самой длинной строки массива
     * @author DEA
     */
    private static int findMaxLength(String[] array) {
        int max = 0;
        for (String element : array) {
            max = Math.max(max, element.length());
        }
        return max;
    }

    /**
     * @param array     массив строк для выравнивания текста по краям
     * @param maxLength длина самой широкой строки
     */
    private static void alignByWidth(String[] array, int maxLength) {
        for (int i = 0; i < array.length; i++) {
            Matcher mSpace = Pattern.compile(" +").matcher(array[i]);
            int offset = 0;
            while (array[i].length() < maxLength) {
                if (mSpace.find()) {
                    int start = mSpace.start();
                    array[i] = new String(new StringBuilder(array[i]).insert(start + offset++, " "));
                } else {
                    mSpace.reset(array[i]);
                    offset = 0;
                }
            }
        }
    }
}
