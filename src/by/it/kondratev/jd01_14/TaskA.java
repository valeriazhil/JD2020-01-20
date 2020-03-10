package by.it.kondratev.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {


    static int i = 20;

    public static void main(String[] args) {
        String binaryFile = Helper.getPath(TaskA.class, "dataTaskA.bin");
        load(binaryFile);
        ArrayList <Integer> list = intolist(binaryFile);
        write_to_txt(list);
    }

    private static void write_to_txt(List<Integer> list) {
        String txtFile = Helper.getPath(TaskA.class, "resultTaskA.txt");
        try (PrintWriter printWriter = new PrintWriter(txtFile))
        {
            double avg = 0;
            for (Integer integer : list) {
                printWriter.write(integer+" ");
                avg += integer;
            }
            printWriter.write("\navg="+avg/i);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static <E> ArrayList <E> intolist(String file_name) {
        List<Integer> list = new ArrayList<>();
        int k=0; int sum = 0;
        try (DataInputStream dis = new DataInputStream
                (new BufferedInputStream
                        (new FileInputStream(file_name)))) {
            while (dis.available()>0) {
                k = dis.readInt();
                list.add(k);
                System.out.print(k+" ");
                sum += k;
            }
            System.out.println("\navg="+ (double)sum/i );
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return (ArrayList<E>) list;
    }


        private static void load(String file_name) {
        try (DataOutputStream dos = new DataOutputStream
                (new BufferedOutputStream
                        (new FileOutputStream(file_name)))) {
            for (int j = 0; j < i; j++) {
                int k = (int)(Math.random()*100);
                dos.writeInt(k);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

