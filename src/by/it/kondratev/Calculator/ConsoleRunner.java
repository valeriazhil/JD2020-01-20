package by.it.kondratev.Calculator;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        Parser parser = new Parser();
        Printer printer = new Printer();

        while (!(string.equals("end"))) {
            Var var = parser.calc(string);
            printer.print(var);
            string = scanner.nextLine();
        }
    }

}
