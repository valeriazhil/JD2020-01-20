package by.it.gerasimov.jd01_14;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

class TaskA {

    public static void main(String[] args) {
        String datFileName = Helper.getPath(TaskA.class) + "dataTaskA.bin";
        writeInt(datFileName);
        List<Integer> list = readInt(datFileName);
        printToConsole(list);
        printToFile(list);
    }

    private static void printToFile(List<Integer> list) {
        File file = new File(Helper.getPath(TaskA.class) + "resultTaskA.txt");
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            double sum2 = 0;
            for (Integer integer : list) {
                writer.printf("%d ", integer);
                sum2 += integer;
            }
            writer.println("\navg=" + sum2 / list.size());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void printToConsole(List<Integer> list) {
        double sum = 0;
        for (Integer integer : list) {
            System.out.printf("%d ", integer);
            sum += integer;
        }
        System.out.println("\navg=" + sum / list.size());
    }

    private static List<Integer> readInt(String datFileName) {
        List<Integer> list = new ArrayList<>();
        try (DataInputStream dis = new DataInputStream(
            new BufferedInputStream(new FileInputStream(datFileName)))) {
            while (dis.available() > 0) {
                list.add(dis.readInt());
            }
        } catch (IOException e) {
            System.err.println("Wow2!!!");
        }
        return list;
    }

    private static void writeInt(String datFileName) {
        try (DataOutputStream dos = new DataOutputStream(
            new BufferedOutputStream(new FileOutputStream(datFileName)))) {
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 1000));
            }
        } catch (IOException e) {
            System.err.println("Wow!!!");
        }
    }
}
