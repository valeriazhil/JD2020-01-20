package by.it.anackij.jd01_15;

//TaskC Нужно реализовать на java приложение - аналог командной строки Windows.
// Приложение должно использовать класс File и поддерживать две команды консоли:
//  команду cd - смена каталога (посмотрите пример: Win+R → cmrd → cd \ → dir ).
// В тестах проверяются всего две команды cd .. и cd имя_папки_в_текущем_каталоге
//  команду dir - вывод каталога, формат вывода  - аналогичный формату в Windows.
//  команда end – завершение работы.
//  Стартовым каталогом при запуске приложения должна быть папка by.it.ваша_фамилия.jd01_15.

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

class TaskC {

    private static String startingPoint = Helper.getPath("TaskC.java", TaskC.class);
    private static Path myPoint = Paths.get(startingPoint).getParent();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Вы находитесь здесь:" + myPoint);
        String s;
        while (true) {
            s = sc.nextLine();
            if (s == null || s.equals("end")) {
                break;
            } else {
                process(s);
            }
        }
    }

    private static void process(String s) {
        switch (s) {
            case "cd ..": {
                System.out.println("Вы вышли из папки");
                myPoint = myPoint.getParent();
                startingPoint = myPoint.toString();
                System.out.println(myPoint);
                break;
            }
            case "dir": {
                printDir();
                break;
            }
            case "end": {
                break;
            }
            default: {
                if (s.matches("cd [-_a-zA-Zа-яА-ЯёЁ0-9]+")) {
                    chooseCatalog(s);
                } else {
                    System.out.println("Такой команды не найдено:(");
                    break;
                }
            }
        }
    }

    private static void printDir (){
        File file = new File(myPoint.toString());
        if (file.isDirectory()) {
            System.out.println("Это папка " + file);
            System.out.println("Список файлов:");

        } else {
            System.out.println("Это не папка");
        }
        File[] files = file.listFiles();
        getFiles(files);
    }

    private static void chooseCatalog(String s) {
        String newFolder = s
                .replace(" ", "")
                .substring(2, s.length() - 1);
        System.out.println("Выбран католог " + newFolder);
        startingPoint = startingPoint + File.separator + newFolder;
        myPoint = Paths.get(startingPoint);
        System.out.println(myPoint);
    }

    private static void getFiles(File[] directory) {
        try {
            for (File file : directory) {
                if (file.isDirectory()) {
                    String path = file.getPath();
                    Object date = Files.getAttribute(Paths.get(path), "basic:creationTime");
                    String d = date.toString();
                    String di = "<DIR>";
                    System.out.printf("%-28s %9s %-20s\n", d, di, file.getName());
                    getFiles(file.listFiles());
                } else {
                    String path = file.getPath();
                    Object date = Files.getAttribute(Paths.get(path), "basic:creationTime");
                    String d = date.toString();

                    System.out.printf("%-28s           %-20s\n", d, file.getName());

                }
            }
        } catch (NullPointerException e) {
            System.out.println("Список пуст");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

