package by.it.makarenko.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;



public class TaskA {

    public static void main(String[] args) {
        String dateFileName = Helper.getPath(TaskA.class,"dataTaskA.bin");
        writeInt(dateFileName);
        List<Integer> list = readInt(dateFileName);
        printToFile(list);
        printToConsole(list);

    }

    private static void printToConsole(List<Integer> list){
        double sum= 0;
        for(Integer integer:list){
            System.out.printf("%d ", integer);
            sum+=integer;
        }
        System.out.printf("\navg=%f\n",sum/list.size());
    }



    private static void printToFile(List<Integer> list) {
        try (
                PrintWriter writer = new PrintWriter(
                    Helper.getPath(TaskA.class, "resultTaskA.txt")
        )) {
            double sum2 = 0;
            for (Integer integer : list) {
                System.out.printf("%d ", integer);
                sum2 += integer;
            }
            writer.printf("\navg=%.2f\n", sum2 / list.size());
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void writeInt(String dateFileName) {
        try(
            DataOutputStream dos = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(dateFileName)
                    )
            )
        ) {
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 1000));
            }
        } catch (IOException e) {
            System.err.println("lul");
        }
    }

    private static List<Integer> readInt(String dateFileName) {
        List<Integer> list = new ArrayList<>();
        try(DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(dateFileName)))){
            while (dis.available()>0){
                list.add(dis.readInt());
            }
        }
        catch (IOException e){
            System.err.println("lol2");
        }
        return list;
    }
}



