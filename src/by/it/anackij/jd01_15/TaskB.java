package by.it.anackij.jd01_15;

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
        String text = codeToFile(fileName); //коммент
        StringBuilder sbb = new StringBuilder(text);
        deleteComments(sbb);
        System.out.println(sbb);
        stringBToFile(sbb, resultFileName);
    }

    private static void stringBToFile(StringBuilder sbb, String fileName) {
        try (PrintWriter pw = new PrintWriter(fileName)
        ) {
            pw.print(sbb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void deleteComments(StringBuilder sbb) {
        for (int i = 0; i < sbb.length() - 2; i++) {
            if (sbb.charAt(i) == '/') {
                switch (sbb.charAt(i + 1)) {
                    case '/': {
                        while (sbb.charAt(i + 2) != '\n') {
                            sbb.deleteCharAt(i + 2);
                        }
                        sbb.deleteCharAt(i + 1);
                        sbb.deleteCharAt(i--);
                        break;
                    }
                    case '*': {
                        if (sbb.charAt(i + 2) == '*') {
                            if (sbb.charAt(i + 3) == '/') {
                                sbb.deleteCharAt(i + 2);
                                sbb.deleteCharAt(i + 2);
                                sbb.deleteCharAt(i);
                                sbb.deleteCharAt(i);
                                sbb.deleteCharAt(i);
                                break;
                            } else {
                                sbb.deleteCharAt(i + 2);
                            }
                        }
                        sbb.deleteCharAt(i + 2);
                        i--;
                        break;
                    }
                }
            }
        }
    }

    private static String codeToFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        try (FileReader fr = new FileReader(fileName)) {
            int c;
            while ((c = fr.read()) != -1) {
                sb.append((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}