package by.it.zhilenkova.jd01.jd01_15;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

class TaskB {
    private static String fileName = Helper.getPath("TaskB.java", TaskB.class);
    private static String resultFileName = Helper.getPath("TaskB.txt", TaskB.class);

    public static void main(String[] args) {
        String text = codeToFile(fileName);
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