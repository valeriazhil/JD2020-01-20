package by.it.kondratev.jd01_06;

import by.it.kondratev.jd01_03.Helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {


    public static void main(String[] args) {

        String sb = new String(Poem.text);
        sb = sb.replace("...", " ");
        String [] sentences = sb.split("[\\.!]"); //\.{1}
        int [][] mas = new int[sentences.length][2];
        for (int i = 0; i < sentences.length; i++) {
            sentences[i] = sentences[i].replace('\n',' ').
                    replace(", "," ").
                    replace(": "," ").
                    replace(" - "," ").trim();
            mas[i][0] = sentences[i].length();
            mas[i][1] = i;
        }
        Helper.sort(mas);
        for (int i = 0; i < mas.length; i++) {
            System.out.println(sentences[mas[i][1]]);

        }


    }
}
