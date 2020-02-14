package by.it.gerasimov.calc;

import java.util.Scanner;

class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        while (true) {
            String expression = scanner.nextLine();
            if (expression.equals("end")) {
                break;
            } else if (expression.equals("printvar")) {
                Var.printVars();
            } else if (expression.equals("sortvar")) {
                Var.sortVars();
            } else {
                Var var = parser.calc(expression);
                printer.print(var);
            }
        }

    }
}
