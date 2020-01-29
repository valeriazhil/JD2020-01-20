package by.it.lomazki.Example;

import java.util.Scanner;

public class Bubble {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;
        str = scanner.nextLine();
        double[] arr = new double[str.length()];

        int i = 0;
        for (String num : str.split(""))
            arr[i++] = Double.valueOf(num);

        sort(arr);
    }

    static void sort(double[ ] arr) {
        boolean swap;
        int last = arr.length;
        do {
            swap = false;
            for (int j = 0; j < last-1; j++) {
                if (arr[j] > arr[j+1]) {
                    double buffer = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = buffer;
                    swap = true;
                }
            }
            last--;
        }
        while (swap);
        for (double i:arr) System.out.print(i + " ");
        System.out.println();
    }
}
