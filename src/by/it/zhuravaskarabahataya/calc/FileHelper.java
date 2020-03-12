package by.it.zhuravaskarabahataya.calc;

import by.it.zhuravaskarabahataya.calc.report.Report;

import java.io.*;
import java.util.HashMap;

public class FileHelper {

    private static final String root = System.getProperty("user.dir");

    static String varsFile = FileHelper.getFilePath("vars.txt", Var.class);
    public static String reportFile = FileHelper.getFilePath("report.txt", Var.class);



    static String getFilePath(String fileName, Class<?> sourceClass) {
        String className = sourceClass.getName();
        String filePath = className
                .replace(sourceClass.getSimpleName(), "")
                .replace('.', File.separatorChar);
        filePath = root + File.separator + "src" + File.separator + filePath + fileName;
        return filePath;
    }

    static void writeVarToFile(String varName, Var var, String filename) {
        try (FileWriter fileWriter = new FileWriter(filename, true)) {
            fileWriter.write(varName + "=" + var + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static HashMap<String, Var> getVarsMapFromFile(String filename) {
        String textFromFile = readTextFromFile(filename);
        HashMap<String, Var> vars = new HashMap<>();
        if (textFromFile.length() != 0) {
           vars = getMapFromString(textFromFile);
        }
        return vars;
    }

    static String readTextFromFile(String fileName) {
        StringBuilder textFromFile = new StringBuilder();
        try (
                FileReader fileReader = new FileReader(fileName)) {
            while (fileReader.ready()) {
                textFromFile.append((char) fileReader.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return textFromFile.toString();
    }

    static HashMap<String, Var> getMapFromString(String text) {
        HashMap<String, Var> vars = new HashMap<>();
        String[] lines = text.split("\n");
        for (String line : lines) {
            String[] partsOfLine = line.split("=");
            String name = partsOfLine[0];
            String var = partsOfLine[1];
            try {
                vars.put(name, Var.create(var));
            } catch (
                    CalcException e) {
                e.printStackTrace();
            }
        }
        return vars;
    }
}
