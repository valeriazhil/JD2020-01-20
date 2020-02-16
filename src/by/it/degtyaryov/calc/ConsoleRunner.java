package by.it.degtyaryov.calc;

import java.util.Scanner;

class ConsoleRunner {
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
            if (expression.equals("printvar")) {
                printer.printVariables(false);
            }
            if (expression.equals("sortvar")) {
                printer.printVariables(true);
            }
            printer.print(parser.calc(expression));
        }
    }
}
