package by.it.bunkov.jd01_15;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

class TaskB {
    public static void main(String[] args) {
        //one line comment
        String text = getWithoutComment();
        saveToFile(text);
    }

    private static String getWithoutComment() {
        StringBuilder text = new StringBuilder(); // field for saving text without comment
        try (BufferedReader reader = new BufferedReader(
                new FileReader(Helper.getPath(TaskB.class, "TaskB.java")))
        ) {
            int ch;
            while ((ch = reader.read()) != -1) {
                if ((char) ch == '/') {
                    ch = reader.read();
                    if ((char) ch == '/') {
                        do {
                            ch = reader.read();
                        } while ((char) ch != '\n' && ch != -1);
                    } else if ((char) ch == '*') {
                        while ((ch = reader.read()) != -1) {
                            if ((char) ch == '*') {
                                ch = reader.read();
                                if ((char) ch == '/') {
                                    ch = reader.read();
                                    break;
                                }
                            }
                        }
                    } else {
                        text.append('/');
                    }
                }
                text.append((char) ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }

    private static void saveToFile(String text) {
        try (PrintWriter writer = new PrintWriter(
                new FileWriter(Helper.getPath(TaskB.class, "TaskB.txt")))
        ) {
            writer.print(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
