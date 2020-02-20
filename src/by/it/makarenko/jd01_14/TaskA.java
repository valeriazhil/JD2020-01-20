package by.it.makarenko.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class TaskA {
    public static void main(String[] args) {
        String dateFileName = Helper.getPath("dataTaskA.bin");
        try(
            DataOutputStream dos = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(dateFileName)))

        ) {
            for (int i = 0; i <20 ; i++) {
                dos.writeInt((int) (Math.random() * 1000));
            }
        }
        catch (IOException ex) {
            System.err.println("lul");
        }
        List<Integer> list = new ArrayList<Integer>();
        try(DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(dateFileName)))){
            while (dis.available()>0){
                list.add(dis.readInt());
            }
        }
        catch (IOException e){
            System.err.println("lol");
        }
        double sum= 0;
        for(Integer integer:list){
            System.out.printf("%d", integer);
            sum+=integer;
        }
        System.out.printf("\navg=%f\n",sum/list.size());

        try {
            PrintWriter writer = new PrintWriter(Helper.getPath("resultTaskA.txt\n"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}



