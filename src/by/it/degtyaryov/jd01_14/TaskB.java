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
        System.out.printf("words=%d, punctuation marks=%d%n", wordsCount, signsCount);
    }

    private static void printToFile(int wordsCount, int signsCount) {
        try (PrintWriter writer = new PrintWriter(
                new FileWriter(Helper.getPath(TaskB.class, "resultTaskB.txt")))
        ) {
            writer.printf("words=%d, punctuation marks=%d%n", wordsCount, signsCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int getWordsCount(String pathToFile) {
        int wordsCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(pathToFile))) {
            String line;
			Pattern pattern = Pattern.compile("[а-яА-ЯёЁ']+");
            while ((line = reader.readLine()) != null) {
                Matcher matchWord = pattern.matcher(line);
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
			Pattern pattern = Pattern.compile("[-.,!?:]");
            while ((line = reader.readLine()) != null) {
                if (line.contains("...")) {
                    line = line.replace("...", ".");
                }
                Matcher matchSign = pattern.matcher(line);
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
