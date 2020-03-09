package by.it.gerasimov.jd01_15;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TaskC {

    private static Path path = Paths.get(Helper.getPath(TaskC.class, ""));

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        process(scanner);
    }

    private static void process(Scanner scanner) {
        String line;
        while (true) {
            try {
                System.out.print("\n" + path.toString() + ">");
                line = scanner.nextLine();
                line = line.trim();
                if (line.equals("end")) {
                    break;
                } else if (line.equals("cd")) {
                    System.out.println(path.toString());
                } else if (line.startsWith("cd")) {
                    changeDirectory(line.substring(2));
                } else if (line.equals("dir")) {
                    showCurrentDirectoryDescription();
                } else {
                    throw new ConsoleException("Не найдена команда \"" + line + "\"");
                }
            } catch (ConsoleException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private static void showCurrentDirectoryDescription() {
        System.out.println("Содержимое папки " + path.toString() + '\n');
        File[] files = path.toFile().listFiles();
        List<Path> paths = new ArrayList<>();
        int size = 0;
        int countDirs = 0;
        int countFiles = 0;
        for (File file : files) {
            paths.add(Paths.get(file.getPath()));
        }
        StringBuilder out = new StringBuilder();
        for (Path file : paths) {
            try {
                out.append(DateFormat.getDateTimeInstance()
                    .format(Files.getLastModifiedTime(file).toMillis())).append('\t');
                if (Files.isDirectory(file)) {
                    out.append("<DIR>").append('\t');
                    countDirs++;
                } else {
                    out.append(Files.size(file)).append('\t');
                    size += Files.size(file);
                    countFiles++;
                }
                out.append(file.getFileName()).append('\t');
                out.append('\n');
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        out.append(countFiles).append(" файлов \t").append(size).append(" байт").append('\n');
        out.append(countDirs).append(" папок");
        System.out.println(out);
    }

    private static void changeDirectory(String line) throws ConsoleException {
        if (line.trim().equals("..")) {
            if (!path.equals(path.getRoot())) {
                path = path.getParent();
            }
        } else if (!line.startsWith(" ")) {
            throw new ConsoleException("Не найдена команда \"cd" + line + "\"");
        } else {
            Path newPath = Paths.get(path.toString() + File.separator + line.trim());
            if (!Files.exists(newPath)) {
                throw new ConsoleException("Системе не удалось найти указанный путь");
            } else if (!Files.isDirectory(newPath)) {
                throw new ConsoleException("Неверно задано имя папки");
            } else {
                path = newPath;
            }
        }
    }
}
