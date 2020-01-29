package by.it.lomazki.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        int quarter = 1;

        System.out.println("Число людей: ");
        Scanner scN = new Scanner(System.in);
        Integer nPeople = scN.nextInt();

        String [] names = new String[nPeople];
        for (int i = 0; i < names.length-1; i++) {
            Scanner scName = new Scanner(System.in);
            String name = scName.next();
            names[i] = name;
        }
        for (int i = 1; i <= 4; i++) {
            quarter = i;
            int [][] arrays = new int[nPeople][quarter];
            for (int i1 = 0; i1 < arrays.length; i1++) {
                System.out.println("Введите зарплату для" + arrays[i1]);
                Scanner scZP = new Scanner(System.in);
                int scZp = scZP.nextInt();
                
            }
        }


        System.out.println("Введите зарплату для");
    }
}
