package by.it.akhmelev.jd01_14;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskAwithoutCatch {

    public static void main(String[] args)  {
        try {
        String datFileName = Helper.getPath(TaskAwithoutCatch.class, "dataTaskA.bin");
        writeInt(datFileName);
        List<Integer> list = readInt(datFileName);
        printToConsole(list);
        printToFile(list);
        } catch (IOException e) {
            System.err.println("Error!"+e);
        }


    }

    private static void printToFile(List<Integer> list) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(
                Helper.getPath(TaskAwithoutCatch.class, "resultTaskA.txt\n")
        )){
            double sum2=0;
            for (Integer integer : list) {
                writer.printf("%d ",integer);
                sum2+=integer;
            }
            writer.printf("\navg=%f\n",sum2/list.size());
        }
    }

    private static void printToConsole(List<Integer> list) {
        double sum=0;
        for (Integer integer : list) {
            System.out.printf("%d ",integer);
            sum+=integer;
        }
        System.out.printf("\navg=%f\n",sum/list.size());
    }

    private static List<Integer> readInt(String datFileName) throws IOException {
        List<Integer> list = new ArrayList<>();
        try (
                DataInputStream dis = new DataInputStream(
                        new BufferedInputStream(
                                new FileInputStream(datFileName)
                        )
                )
        ) {
            while (dis.available() > 0) {
                list.add(dis.readInt());
            }
        }
        return list;
    }

    private static void writeInt(String datFileName) throws IOException {
        try (
                DataOutputStream dos = new DataOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(datFileName)
                        )
                )
        ) {
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 1000));
            }
        }
    }


}
