package by.it.dolgiy.jd01_13;

import java.util.ArrayList;
import java.util.Scanner;

class TaskC {

//    static void readData(){
//        ArrayList<Double> values = new ArrayList<>();
//        for (Double value : values) {
//            value = ;
//        }
//    }

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Double> values = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true){
            try {
                double value = scanner.nextDouble();
                values.add(0,value);
            }
            catch (Exception e){
                Thread.sleep(100);
                for (Double value1 : values) {
                    System.out.print(value1);
                }
            }
        }
    }
}
