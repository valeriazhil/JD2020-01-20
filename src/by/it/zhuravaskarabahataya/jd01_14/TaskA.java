package by.it.zhuravaskarabahataya.jd01_14;

//А. В классе TaskA нужно выполнить следующие шаги:
// Записать в двоичный файл dataTaskA.bin 20 случайных чисел типа Integer.
// Файл должен быть в том же каталоге, что и исходный код для класса
//TaskA.java.
// Затем нужно прочитать записанный файл в коллекцию ArrayList.
// Вывести в консоль прочитанные числа через пробел
// Вывести с новой строки их среднее арифметическое avg=20.123.
// Продублировать вывод в консоль в файл resultTaskA.txt

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class TaskA {

    public static void main(String[] args) {
        String datFileName = Helper.getPath("dataTaskA.bin");
        System.out.println(datFileName);
        String resultFile = Helper.getPath("resultTaskA.txt");
        writeIntToBinFile(datFileName);
        List<Integer> integers = new ArrayList<>();
        readtoArrayList(integers, datFileName);
        printArray(integers);
        printIntegersFromFile(datFileName, resultFile);
    }


    private static void writeIntToBinFile(String filename) {
        try (DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(filename)))) {

            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 100));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readtoArrayList(List<Integer> integers, String filename) {
        try (DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(filename)))) {
            while (dis.available() > 0) {
                integers.add(dis.readInt());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void printArray(List<Integer> integers) {
        for (Integer integer : integers) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }


    private static void printIntegersFromFile(String from, String to) {
        try (DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(
                                from)));
             PrintWriter out = new PrintWriter(
                     new FileWriter(to))) {
            double sum = 0;
            double count = 0;
            while (dis.available() > 0) {
                int i = dis.readInt();
                System.out.print(i + " ");
                out.print(i + " ");
                sum += i;
                count++;
            }
            System.out.println("\navg=" + sum / count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


//        writeInt(datFileName);
//
//        ArrayList<Integer> integerList = new ArrayList<>();
//        readInt(datFileName, integerList);
//
//        printListToConsole(integerList);
//        printListToFile(integerList);


//private  static void readInt(String datFileName, ArrayList<Integer> list) {
//    try (DataInputStream dis = new DataInputStream(
//            new BufferedInputStream(
//                    new FileInputStream(datFileName)))) {
//        while (dis.available()>0){
//            list.add(dis.readInt());
//        }
//    } catch (IOException e) {
//        System.err.println(e);
//        System.err.println("OOOPS I DID IT AGAIN");
//    }
//}
//
//    private static void printListToFile(ArrayList<Integer> list) {
//        try {
//            PrintWriter pw = new PrintWriter(Helper.getPath(TaskA.class, "resultTaskA.txt"));
//            double sum2 = 0;
//            for (Integer integer : list) {
//                sum2 += integer;
//                pw.printf("%d ", integer);
//
//            }
//            pw.printf("\n avg=%f", sum2 / list.size());
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static void printListToConsole(ArrayList<Integer> list) {
//        double sum = 0;
//        for (Integer integer : list) {
//            sum +=integer;
//            System.out.printf("%d ", integer);
//            System.out.println();
//        }
//        System.out.printf("\n avg=%f", sum/list.size());
//    }
//
//
//
//    private static void writeInt(String datFileName) {
//        try (
//                DataOutputStream dos = new DataOutputStream(
//                        new BufferedOutputStream(
//                                new FileOutputStream(datFileName)))
//        ) {
//            for (int i = 0; i < 20; i++) {
//                dos.writeInt((int) (Math.random() * 1000));
//            }
//            dos.writeInt('D' + 256 * 'C' + 256 * 256 * 'B' + 256 * 256 * 256 * 'A');
//        } catch (IOException e) {
//            System.err.println(e);
//            System.err.println("OOOPS");
//        }
//    }



