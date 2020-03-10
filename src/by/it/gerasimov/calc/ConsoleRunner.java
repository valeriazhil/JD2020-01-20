package by.it.gerasimov.calc;

import by.it.gerasimov.calc.translate.Globalization;
import java.util.Scanner;

class ConsoleRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        Globalization.greetings();
        while (true) {
            Var.loadVars();
            String expression = scanner.nextLine();
            if (expression.equals("end")) {
                break;
            } else if (expression.equals("printvar")) {
                Var.printVars();
            } else if (expression.equals("sortvar")) {
                Var.sortVars();
            } else if (expression.startsWith("lang")) {
                Globalization.switchLang(expression.substring(4));
                Globalization.greetings();
            } else {
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
