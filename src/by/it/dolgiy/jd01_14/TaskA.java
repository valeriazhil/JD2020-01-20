package by.it.dolgiy.jd01_14;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

class TaskA {

    public static void main(String[] args) {
        String datFileName = TaskH.getPath(TaskA.class,"dataTaskA.bin");
        intWrite(datFileName);
        List<Integer> list = readInt(datFileName);
        printToConsole(list);
        printToFile(list);
    }

    private static void intWrite(String datFileName) {
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(datFileName)))){
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random()*100));
            }
        } catch (IOException e) {
            System.out.println("ERROR:");
        }
    }

    private static List<Integer> readInt(String datFileName) {
        List<Integer> list = new ArrayList<>();
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(datFileName)))) {
            while (dis.available() > 0) {
                list.add(dis.readInt());
            }
        } catch (IOException e) {
            System.out.println("ERROR:");
        }
        return list;
    }

    private static void printToConsole(List<Integer> list) {
        double sum=0.0;
        for (Integer integer : list) {
            System.out.printf("%d ",integer);
            sum+=integer;
        }
        double avg = sum/list.size();
        String avgs = Double.toString(avg);
        System.out.printf("\navg=%s\n",avgs);
    }

    private static void printToFile(List<Integer> list) {
        try (PrintWriter writer = new PrintWriter(
                TaskH.getPath(TaskA.class, "resultTaskA.txt")
        )){
            double sum2=0.0;
            for (Integer integer : list) {
                writer.printf("%d ",integer);
                sum2+=integer;
            }
            double avg2 = sum2/list.size();
            String avgs2 = Double.toString(avg2);
            writer.printf("\navg=%s\n",avgs2);
        } catch (FileNotFoundException e) {
            System.out.println("ERROR");
        }
    }



}
