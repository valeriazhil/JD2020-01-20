package by.it.degtyaryov.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskB {

    public static void main(String[] args) {
        String filePath = Helper.getPath(TaskB.class, "text.txt");
        String fileContent = getTextFromFile(filePath);
        int wordsCount = getWordsCount(fileContent);
        int signsCount = getSignsCount(fileContent);
        printToConsole(wordsCount, signsCount);
        printToFile(wordsCount, signsCount);
    }

    private static String getTextFromFile(String pathToFile) {
        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(pathToFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line);
                text.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }

    private static int getWordsCount(String text) {
        Pattern patternWord = Pattern.compile("[а-яА-ЯёЁ']+");
        Matcher word = patternWord.matcher(text);
        int count = 0;
        while (word.find()) {
            count++;
        }
        return count;
    }

    private static int getSignsCount(String text) {
        text = text.replace("...", ".");
        Pattern patternSign = Pattern.compile("[-.,!?:]");
        Matcher sign = patternSign.matcher(text);
        int count = 0;
        while (sign.find()) {
            count++;
        }
        return count;
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
}
