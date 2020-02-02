package by.it.lomazki.Example;

import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Weight = scanner.nextInt();
        System.out.println(getWeight(Weight));

    }

    static double getWeight(int y) {
        double eWeight = 9.81;
        double mWeight = 3.86;
        double em = mWeight / eWeight;
        double getWeight = y;
        double marsWeight=(getWeight*em);

        System.out.println(marsWeight);
        return marsWeight;
    }
}


