package by.it.zhilenkova.jd02.ZhilenkovaCalcAll;

import by.it.zhilenkova.jd02.ZhilenkovaCalcAll.localization.Message;
import by.it.zhilenkova.jd02.ZhilenkovaCalcAll.localization.TranslateManager;
import by.it.zhilenkova.jd02.ZhilenkovaCalcAll.reportBuilder.LongReportBuilder;
import by.it.zhilenkova.jd02.ZhilenkovaCalcAll.reportBuilder.ReportBuilder;
import by.it.zhilenkova.jd02.ZhilenkovaCalcAll.reportBuilder.ShortReportBuilder;

import java.util.Scanner;

public class ConsoleRunner {

    static ReportBuilder report;

    public static void main(String[] args) {
        String expression;
        Scanner scanner = new Scanner(System.in);
        Parcer parcer = new Parcer();
        Printer printer = new Printer();

        TranslateManager tm = TranslateManager.INSTANCE;
        //private TranslateManager tm = TranslateManager.INSTANCE;
        // tm.get(Message.REPORT)
        Var.loadVarFromFile();
        for(; ;) {
            System.out.println(tm.get(Message.REPORT));
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("short")) {
                report = new ShortReportBuilder();
                System.out.println("Short log style");
                break;
            }
            else if (input.equalsIgnoreCase("long")) {
                report = new LongReportBuilder();
                System.out.println("Long log style");
                break;
            }
            else
                System.out.println("Input error. Try again");
        }
            report.printHeader();
            report.printStartUseTime();
        while (!(expression = scanner.nextLine()).equalsIgnoreCase("end")) {
            if (expression.equalsIgnoreCase("ru")) {
                tm.setLocale("ru", "RU");
                System.out.println("Сообщения об ошибках на русском языке");
            } else if (expression.equalsIgnoreCase("be")) {
                tm.setLocale("be", "BY");
                System.out.println("Паведамленнi аб памылках на беларускай мове");
            } else if (expression.equalsIgnoreCase("en")) {
                tm.setLocale("en", "US");
                System.out.println("Error messages an english");
            }
            else {
                String result;
                try {
                    result = parcer.calc(expression);
                    printer.print(result);
                    report.printOperations(expression, result);

                } catch (CalcException e) {
                    report.printExceptions(e);
                    printer.showError(e);
                }
            }
        }
        report.printEndUseTime();
        Var.saveVarToFile();
    }
}
