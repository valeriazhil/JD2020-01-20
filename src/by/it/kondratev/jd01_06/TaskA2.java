package by.it.kondratev.jd01_06;

import java.lang.reflect.Array;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        String[][] mas = new String[500][2];
        for (int i = 0; i < mas.length; i++) {
            mas[i][0] = "0";
        }
        matcher.find(); mas[0][0] = matcher.group(); mas[0][1]="1";
        while (matcher.find()) {
            for (int i = 0; i < mas.length-1; i++) {
                if (matcher.group().equals(mas[i][0])) {
                    mas[i][1] = String.valueOf((Integer.parseInt(mas[i][1]) + 1));
                    break;}
                else if (mas[i+1][0] == "0") {
                    mas[i+1][0] = matcher.group();
                    mas [i+1][1] = "1"; break;}
                else continue;
            }
        }

        for (int i = 0; i < mas.length; i++) {
            System.out.println(mas[i][0]+"="+mas[i][1]);
            if (mas[i+1][0] == "0") break;
        }
    }

}
