package by.it.dolgiy.jd01_15;
//комментарий 1
//комментарий 2
/*комментарий 3
 комментарий 3*/
/*комментарий 4
комментарий 4*/
/**
 * @author комментарий 5
 * @param комментарий 5
 */


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


class TaskB {

    public static void main(String[] args) {
        String fileNameRead = TaskH.getPath(TaskB.class,"TaskB.java");
        String fileNameWrite = TaskH.getPath(TaskB.class,"TaskB.txt");
        Path pathReade = Paths.get(fileNameRead);
        StringBuilder sb = new StringBuilder();
        readLines(pathReade, sb);
        removeComments(sb);
        System.out.println(sb);
        printLines(fileNameWrite, sb);
    }

    private static void printLines(String fileNameWrite, StringBuilder sb) {
        try (final PrintWriter printWriter = new PrintWriter(fileNameWrite)){
            printWriter.println(sb);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void removeComments(StringBuilder sb) {
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i)=='/'){
                if (sb.charAt(i+1)=='/'){
                    while (sb.charAt(i)!='\n'){
                        sb.deleteCharAt(i);
                    }
//                    sb.deleteCharAt(i);
                    i--;
                }
                if (sb.charAt(i+1)=='*'){
                    while (sb.charAt(i+1)!='/'){
                        sb.deleteCharAt(i);
                    }
                    sb.deleteCharAt(i+1);
                    sb.deleteCharAt(i);
//                    sb.deleteCharAt(i);
                    i--;
                }
            }
        }
    }

    private static void readLines(Path pathReade, StringBuilder sb) {
        try {
            List<String> list = Files.readAllLines(pathReade);
            for (String s : list) {
                sb.append(s).append('\n');
            }
        } catch (IOException e) {
            System.out.println("Error:"+e);
        }
    }

}
