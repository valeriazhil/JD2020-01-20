package by.it.dolgiy.jd01_04;

import java.util.Scanner;

class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = scanner.next();
        }
        int[][] zp = new int[n][4];
        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату для "+str[i]);
            for (int j = 0; j < 4; j++) {
                zp[i][j] = scanner.nextInt();
            }
        }
        System.out.println("______________________________________________________________________");
        System.out.printf("%-15s%-10s%-10s%-10s%-10s%-10s%n","Фамилия","Квартал1","Квартал2","Квартал3","Квартал4","Итого");
        System.out.println("______________________________________________________________________");
        int[] total = new int[n];
        for (int i = 0; i < n; i++) {
            total [i] = zp[i][0]+zp[i][1]+zp[i][2]+zp[i][3];
        }
        for (int i = 0; i < n; i++) {
            System.out.printf("%-15s",str[i]);
            for (int j = 0; j < 4; j++) {
                System.out.printf("%-10d",zp[i][j]);
            }
            System.out.printf("%-10d",total[i]);
            System.out.println();
        }
        System.out.println("______________________________________________________________________");

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum=sum+total[i];
        }
        System.out.printf("%-15s%-10d%n","Итого",sum);
        double sr = (double) sum/(n*4);
        System.out.printf("%-15s%-10.4f","Средняя",sr);
    }

}
