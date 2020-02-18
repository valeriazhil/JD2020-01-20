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
        int counter = 0;
        while (true){
            try {
                String text = scanner.next();
                double value = Double.parseDouble(text);
                values.add(0,value);
            }
            catch (Exception e){
                Thread.sleep(100);
                for (Double value1 : values) {
                    System.out.print(value1);
                }
                counter++;
            }
            if (counter==5){
                System.out.println();
                throw new InterruptedException();
            }
        }
    }
}
