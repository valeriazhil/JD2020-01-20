package by.it.pkochubei.jd01_13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TaskC {
    static Scanner sc;

    public static void main(String[] args) throws InterruptedException {
        sc = new Scanner(System.in);
        while (true) {
            readData();
        }
    }

    static void readData() throws InterruptedException {
        int counterOfExceptions = 0;
        ArrayList<Double> list = new ArrayList<>();
        while (counterOfExceptions<7){
            try{
                double number = Double.parseDouble(sc.nextLine());
                list.add(number);
            }
            catch (NumberFormatException e) {
                Thread.sleep(100);
                counterOfExceptions++;
                Collections.reverse(list);
                for (Double aDouble : list) {
                    System.out.print(aDouble + " ");
                }
                System.out.println();
                Collections.reverse(list);
                if (counterOfExceptions == 5){
                    throw e;
                }
            }
        }
    }
}
