package by.it.degtyaryov.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression;
        Parser parser = new Parser();
        Printer printer = new Printer();

        while (true) {
            expression = scanner.nextLine();
            if (expression.equals("end")) {
                return;
            }
            printer.print(parser.calc(expression));
        }
    }
}
