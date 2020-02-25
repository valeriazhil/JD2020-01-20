package by.it.dolgiy.jd01_15;

/**
 * @param комментарий 5
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;



class TaskB {
    public static void main(String[] args) {
        //комментарий 1
        //комментарий 2
        String fileNameRead = TaskH.getPath(TaskB.class,"TaskB.java");
        Path pathReade = Paths.get(fileNameRead);
        String fileNameWrite = TaskH.getPath(TaskB.class,"TaskB.txt");
        Path pathWrite = Paths.get(fileNameWrite);
        /*комментарий 3
        комментарий 3 */
        /*комментарий 4
        комментарий 4*/
        StringBuilder sb = new StringBuilder();
        try {
            List<String> list = Files.readAllLines(pathReade);


            for (String s : list) {
                sb.append(s).append('\n');
            }
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
