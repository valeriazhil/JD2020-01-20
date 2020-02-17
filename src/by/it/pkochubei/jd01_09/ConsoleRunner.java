package by.it.pkochubei.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String line;
        Parcer parcer = new Parcer();
        Printer printer = new Printer();
        while (!(line = scn.nextLine()).equals("end")){
            Var result = parcer.calc(line);
            printer.print(result);
        }
    }
}
