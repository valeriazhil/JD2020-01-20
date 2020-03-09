package by.it.makarenko.jd01_14;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskB {
    public static void main(String[] args) {
        String txtFile = HelperB.getPath(TaskB.class, "TaskB.txt");
        System.out.println(txtFile);
        List<String> list = readStr(txtFile);
        writeStr(txtFile);
    }
    private static void writeStr(String txtFile){
        try(DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(txtFile)))){

        }catch (IOException e){
            System.out.println("lol");
        }
    }
    private static List<String> readStr(String txtFile){
        List<String> list = new ArrayList<>();
        try(DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(txtFile)))){
            while (dis.available()>0){
                list.add(dis.readUTF());
            }
        }catch (IOException e){
            System.out.println("test");
        }
        return list;
    }

}
