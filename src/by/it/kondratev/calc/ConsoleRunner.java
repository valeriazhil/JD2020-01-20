package by.it.kondratev.calc;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String expression;

        Parser parser = new Parser();
        Printer printer = new Printer();

        while (true) {
            expression = scanner.nextLine();
            switch (expression) {
                case ("end"):
                    return;
                case ("printvar"):
                    printer.printVar(Var.vars);
                    continue;
                case ("sortvar"):
                    printer.sortvar(Var.vars);
                    continue;
                default:
                    try {
                        Var var = parser.calc(expression);
                        printer.print(var);
                    } catch (CalcException e) {
                        System.out.println(e.getMessage());
                    }
            }
        }
    }
}
