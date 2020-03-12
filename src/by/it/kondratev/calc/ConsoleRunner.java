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
                case ("all events report"):
                    ReportBuilder.allEventsReportBuilder();
                    System.out.println("Отчет находится в файле \"All events report.txt\"");
                    continue;
                case ("errors report"):
                    ReportBuilder.errorsReport();
                    System.out.println("Отчет находится в файле \"Errors report.txt\"");
                    continue;
                case ("errors short report"):
                    ReportBuilder.errorsShortReport();
                    System.out.println("Отчет находится в файле \"Errors short report.txt\"");
                    continue;
                default:
                    try {
                        Var var = parser.calc(expression);
                        printer.print(var);
                        CalcLogger.calcLogger.log("Введено выражение: " + expression +
                                "\nПолучен результат: " + var + '\n', 1);
                    } catch (CalcException e) {
                        System.out.println(e.getMessage());
                        CalcLogger.calcLogger.log("Введено выражение: " + expression +
                                "\nПолучена ошибка " + e.getMessage() + '\n', 1);
                        CalcLogger.calcLogger.log(e.toString() + '\n',3);
                        CalcLogger.calcLogger.log(
                                "Введено выражение: " + expression +
                                "\nПолучена ошибка " + e.getMessage() + '\n',2);
                    }
            }
        }
    }
}
