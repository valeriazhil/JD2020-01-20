package by.it.lomazki.Example;

import java.util.Scanner;

public class TaskC3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int Weight = scanner.nextInt();
        System.out.println(getWeight(Weight));

    }

    static double getWeight(int y) {
        double eWeight = 9.81;
        double mWeight = 3.86;
        double getWeight = y;
        double marsWeight1=(int)((getWeight*mWeight / eWeight)*100);
        double marsWeight =  marsWeight1/100;

        System.out.println(marsWeight);
        return marsWeight;
    }
}
