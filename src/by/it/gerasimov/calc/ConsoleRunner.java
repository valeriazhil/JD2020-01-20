package by.it.gerasimov.calc;

import by.it.gerasimov.calc.translate.Globalization;
import by.it.gerasimov.calc.translate.Messages;
import by.it.gerasimov.calc.translate.ResMan;
import java.util.Scanner;

class ConsoleRunner {

    static void printReport(String size) {
        try {
            size = size.trim();
            ReportBuilder builder;
            if (size.equals("short")) {
                builder = new ShortReportBuilder();
            } else if (size.equals("full")) {
                builder = new FullReportBuilder();
            } else {
                throw new CalcException(ResMan.INSTANCE.get(Messages.INVALID_INPUT));
            }
            Report report = new Report();
            report.setBuilder(builder);
            report.printReport();
        } catch (CalcException e) {
            System.out.println(e.getMessage());
        }
    }

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
            } else if (expression.startsWith("report")) {
                printReport(expression.substring(6));
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
