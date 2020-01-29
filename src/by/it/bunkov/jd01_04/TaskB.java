package by.it.bunkov.jd01_04;

import java.util.Scanner;



public class TaskB {

    public static void main(String[] args) {

           Scanner sc = new Scanner(System.in);
                   int n = sc.nextInt();
                   sc.nextLine();  // как по-другому???

        String[] a = new String[n];

        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextLine();
        }

        int[ ][ ] m=new int[n][4];
        for (int i = 0; i < m.length; i++) {
            System.out.println("Enter salary for" + a[i]+ ", please.");
            for (int j = 0; j < m[0].length; j++) {
                m[i][j] = sc.nextInt();
            }
        }




    }


}
