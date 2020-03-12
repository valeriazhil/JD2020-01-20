package by.it.kondratev.jd01_15;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

class TaskC {

    private static File file = new File(Helper.getPath(TaskC.class, ""));

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(file);
            System.out.print("Введите команду: ");
            String command = scanner.nextLine();
            if (command.equals("end")) {
                break;
            } else if (command.equals("dir")) {
                dir();
            } else if (command.matches("cd .+")) {
                file = cd(command.replace("cd ", ""));
            } else {
                System.out.println("Команда не распознана");
            }
        }
    }

    private static void dir() {
        Date calendar;
        String date, time, isDirectory, size, name;
        File[] files = file.listFiles();
        files = (files != null) ? files : new File[0];

        for (File file : files) {
            calendar = new Date(file.lastModified());
            date = String.format("%1$td.%1$tm.%1$tY", calendar);
            time = String.format("%tH:%tM", calendar, calendar);
            isDirectory = (file.isDirectory()) ? "<DIR>" : "";
            size = (file.isFile()) ? String.valueOf(file.length()) : "";
            name = file.getName();
            System.out.printf("%-11s %-6s %-6s %6s %-1s%n", date, time, isDirectory, size, name);
        }
        System.out.println();
    }

    private static File cd(String path) {
        File newPath = null;
        try {
            newPath = new File(file, "/" + path).getCanonicalFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (newPath != null && !newPath.exists()) {
            System.out.println("invalid path");
            return file;
        }
        return newPath;
    }
}
