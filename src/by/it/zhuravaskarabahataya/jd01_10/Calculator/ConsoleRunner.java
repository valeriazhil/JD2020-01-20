package by.it.zhuravaskarabahataya.jd01_10.Calculator;

import java.util.Scanner;

class ConsoleRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            String expression = sc.nextLine();
            if (expression.equals("end")){
                break;
            }
            Calculator calc = new Calculator(expression);
        }
    }
}
