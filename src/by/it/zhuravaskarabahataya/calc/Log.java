package by.it.zhuravaskarabahataya.calc;

import java.io.*;

class Log {
    static String logFile = FileHelper.getFilePath("log.txt", FileHelper.class);

    static void writeExceptionToLogFile(String exceptionMessage) {
        try (FileWriter pw = new FileWriter(logFile, true)) {
            pw.write(exceptionMessage + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void writeExpressionToLogFile(String expression, String result) {
        try (FileWriter pw = new FileWriter(logFile, true)) {
            pw.write(expression + "=" + result + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void addLogCount(int lineNumber) {
        if (lineNumber > 10) {
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
        addLogCount(lineNumber);
        return lineNumber;
    }

    private static void deleteFirtsLineFromLog() {
        try {
            FileWriter fileWriter = new FileWriter(logFile);
            fileWriter.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
