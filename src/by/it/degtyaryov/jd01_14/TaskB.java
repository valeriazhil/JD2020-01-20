package by.it.degtyaryov.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskB {

    public static void main(String[] args) {
        String pathToFile = Helper.getPath(TaskB.class, "text.txt");
        int wordsCount = getWordsCount(pathToFile);
        int signsCount = getSignsCount(pathToFile);
        printToConsole(wordsCount, signsCount);
        printToFile(wordsCount, signsCount);
    }

    private static void printToConsole(int wordsCount, int signsCount) {
        System.out.println("words=" + wordsCount + ", punctuation marks=" + signsCount);
    }

    private static void printToFile(int wordsCount, int signsCount) {
        try (PrintWriter printWriter = new PrintWriter(
                new FileWriter(Helper.getPath(TaskA.class, "resultTaskB.txt")))
        ) {
            printWriter.println("words=" + wordsCount + ", punctuation marks=" + signsCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int getWordsCount(String pathToFile) {
        int wordsCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(pathToFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matchWord = Pattern.compile("[а-яА-ЯёЁ']+").matcher(line);
                while (matchWord.find()) {
                    wordsCount++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordsCount;
    }

    private static int getSignsCount(String pathToFile) {
        int signCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(pathToFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("...")) {
                    line = line.replace("...", ".");
                }
                Matcher matchSign = Pattern.compile("[-.,!?:]").matcher(line);
                while (matchSign.find()) {
                    signCount++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return signCount;
    }
}
