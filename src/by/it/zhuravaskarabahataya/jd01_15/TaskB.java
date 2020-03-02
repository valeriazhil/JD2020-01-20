package by.it.zhuravaskarabahataya.jd01_15;

/**
 * @author ya  @author ya
 */

//hvhvn

import java.io.FileNotFoundException; //edekhce
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

// (s=“//так не бывает”) и внутри комментария тоже
/* Многострочный
комментрий
 */
    /*В программе создайте хотя бы 5 разных комментариев:
 с тем же местоположением и именем,
 но с расширением txt, а не java.  Считайте, что комментарии внутри строки невозможны
*/
class TaskB {
    private static String fileName = Helper.getPath("TaskB.java", TaskB.class);
    private static String resultFileName = Helper.getPath("TaskB.txt", TaskB.class);

    public static void main(String[] args) {
        String text = readCodeFromFile(fileName); //коммент
        String textWithoutComments = deleteComments(text);
        System.out.println(textWithoutComments);
        writeTextToFile(textWithoutComments, resultFileName);
    }

    private static String readCodeFromFile(String fileName) {
        StringBuilder textConstructor = new StringBuilder();
        try (FileReader fileReader = new FileReader(fileName)) {
            int oneSymbol;
            while ((oneSymbol = fileReader.read()) != -1) {
                textConstructor.append((char) oneSymbol);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return textConstructor.toString();
    }

    private static String deleteComments(String text) {
        StringBuilder textBuilder = new StringBuilder(text);
        for (int i = 0; i < textBuilder.length() - 2; i++) {
            if (textBuilder.charAt(i) == '/') {
                switch (textBuilder.charAt(i + 1)) {
                    case '/': {
                        Comment.SINGLE_lINE_COMMENT.deleteComment(textBuilder, i);
                        break;
                    }
                    case '*': {
                        Comment.MULTIPLE_LINE_COMMENT.deleteComment(textBuilder, i);
                        break;
                    }
                }
            }
        }
        return textBuilder.toString();
    }

    private static void writeTextToFile(String text, String fileName) {
        try (PrintWriter pw = new PrintWriter(fileName)
        ) {
            pw.print(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}