package by.it.zhuravaskarabahataya.calc;

import java.io.*;
import java.util.Scanner;

class Log {
    static String logFile = FileHelper.getFilePath("log.txt", FileHelper.class);

    static void writeExceptionToLogFile(String exceptionMessage) {
        try (FileWriter pw = new FileWriter(logFile, true)) {
            checkLogLineCount();
            pw.write(exceptionMessage + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//
//    static void writeExpressionWithoutResultToLogFile(String expression) {
//        try (FileWriter pw = new FileWriter(logFile, true)) {
//            checkLogLineCount();
//            pw.write(expression + "\n");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

//    static void writeResultToLogFile(String expression, String result) {
//        try (FileWriter pw = new FileWriter(logFile, true)) {
//            checkLogLineCount();
//            pw.write( expression + " = " + result + "\n");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    static void checkLogLineCount() {
        int lineNumber = countLines();
        if (lineNumber > 49) {
            deleteFirtsLineFromLog();
        }
    }

    private static int countLines() {
        File logFile = new File(Log.logFile);
        int lineNumber = 0;
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(logFile));
            while (lineNumberReader.readLine() != null) {
                lineNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineNumber;
    }

    private static void deleteFirtsLineFromLog() {
        String[] dataFromLogFile = readDataFromLogFile();
        String[] dataFromLogFileWithoutFirst = new String[dataFromLogFile.length - 1];
        System.arraycopy(dataFromLogFile, 1, dataFromLogFileWithoutFirst,
                0, dataFromLogFileWithoutFirst.length);
        clearLogFile();
        writeNewLog(dataFromLogFileWithoutFirst);
    }

    private static void writeNewLog(String[] dataFromLogFileWithoutFirst) {
        try (FileWriter pw = new FileWriter(logFile, true)) {
            for (String s : dataFromLogFileWithoutFirst) {
                pw.write(s + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void clearLogFile() {
        try {
            FileWriter fileWriter = new FileWriter(logFile, false);
            fileWriter.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String[] readDataFromLogFile() {
        int lineCount = countLines();
        String[] stringArray = new String[lineCount];
        try {
            FileReader fileReader = new FileReader(logFile);
            Scanner scanner = new Scanner(fileReader);
            for (int i = 0; i < stringArray.length; i++) {
                stringArray[i] = scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return stringArray;
    }

}
