package by.it.kondratev.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            if (test(matcher.group())) System.out.println(matcher.group());
        }
    }

    private static boolean test(String str){
        char [] gl = {'а','о','у','ы','и','ю','я','ё','е','э'};
        str = str.toLowerCase();
        for (int i = 0; i < gl.length ; i++) {
            if (str.charAt(0)==gl[i]) return false;
        }
        int last = str.length()-1;
        for (int i = 0; i < gl.length ; i++) {
            if (str.charAt(last)==gl[i]) return true;
        }
        return false;
    }

}