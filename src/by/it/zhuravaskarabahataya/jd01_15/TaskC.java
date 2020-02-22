package by.it.zhuravaskarabahataya.jd01_15;

//TaskC Нужно реализовать на java приложение - аналог командной строки Windows.
// Приложение должно использовать класс File и поддерживать две команды консоли:
//  команду cd - смена каталога (посмотрите пример: Win+R → cmrd → cd \ → dir ).
// В тестах проверяются всего две команды cd .. и cd имя_папки_в_текущем_каталоге
//  команду dir - вывод каталога, формат вывода  - аналогичный формату в Windows.
//  команда end – завершение работы.
//  Стартовым каталогом при запуске приложения должна быть папка by.it.ваша_фамилия.jd01_15.

import java.io.File;
import java.nio.file.*;
import java.util.Scanner;

class TaskC {

    private static String startingPoint = Helper.getPath("TaskC.java", TaskC.class);
    private static Path myPoint = Paths.get(startingPoint);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(startingPoint);
        String s;
        Path p1 = Paths.get(startingPoint + File.separator);
        Path p2 = p1.getParent();

        System.out.println(myPoint);
        Files files;
        FileSystem fs = FileSystems.getDefault();
        System.out.println(fs);
        while (true) {
            s = sc.nextLine();
            if (s != null && s.equals("end")) {
                break;
            } else {
                procees(s);
            }
        }

    }

    private static void procees(String s) {
        switch (s) {
            case "cd ..": {
                System.out.println("Вы вышли из папки");
                myPoint = myPoint.getParent();
                System.out.println(myPoint);
                break;
            }
            case "dir": {
                System.out.println("Список файлов:");
                break;
            }
            case "end": {
                break;
            }
            default: {
                if (s.matches("cd [a-zA-Zа-яА-ЯёЁ0-9]+")){
                    String newFolder = s
                            .replace(" ","")
                            .substring(2, s.length() -1);
                    System.out.println("Выбран католог " + newFolder);
                }
                else{
                System.out.println("Такой команды не найдено:(");
                break;}
            }
        }
    }
}

