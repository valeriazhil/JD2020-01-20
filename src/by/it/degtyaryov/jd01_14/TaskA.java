package by.it.degtyaryov.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class TaskA {

    public static void main(String[] args) {
        String pathToFile = Helper.getPath(TaskA.class, "dataTaskA.bin");
        writeRandomInts(pathToFile);
        List<Integer> list = readFile(pathToFile);
        printToConsole(list);
        printToFile(list);
    }

    private static void writeRandomInts(String path) {
        try (DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(path)))) {
            for (int i = 0; i < 20; i++) {
                out.writeInt((int) (Math.random() * 1000));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Integer> readFile(String path) {
        List<Integer> list = new ArrayList<>();
        try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(path)))) {
            while (in.available() > 0) {
                list.add(in.readInt());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static void printToConsole(List<Integer> list) {
        double sum = 0;
        for (Integer num : list) {
            System.out.printf("%d ", num);
            sum += num;
        }
        System.out.printf("\navg=%f\n", sum / list.size());
    }

    private static void printToFile(List<Integer> list) {
        try (PrintWriter printWriter = new PrintWriter(
                new FileWriter(Helper.getPath(TaskA.class, "resultTaskA.txt")))
        ) {
            double sum = 0;
            for (Integer num : list) {
                printWriter.printf("%d ", num);
                sum += num;
            }
            printWriter.printf("\navg=%f\n", sum / list.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}