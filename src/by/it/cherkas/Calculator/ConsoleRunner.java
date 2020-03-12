package by.it.cherkas.Calculator;

import by.it.cherkas.Calculator.translate.ResMan;
import by.it.cherkas.Calculator.report.*;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

class ConsoleRunner {

    public static void main(String[] args) {
        ReportDirector.setLaunchTime(DateFormat.getDateTimeInstance().format(new Date()));
        ResMan man = ResMan.INSTANCE;
        Scanner sc = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        while (true) {
            String expr = sc.nextLine();
            Logger.getInstance().log("\n" + expr);
            ReportDirector.addOperation("\n"+ expr);
            if (expr.equals("end")) {
                ReportDirector.setFinish(DateFormat.getDateTimeInstance().format(new Date()));
                ReportDirector reportDirector = new ReportDirector();
                BriefReportBuilder briefReportBuilder = new BriefReportBuilder();
                reportDirector.buildReport(briefReportBuilder);
                FullReportBuilder fullReportBuilder = new FullReportBuilder();
                reportDirector.buildReport(fullReportBuilder);
                break;
            }
            switch (expr) {
                case "ru":
                    Locale locale = new Locale("ru");
                    man.setLocale(locale);
                    break;
                case "en":
                    ResMan.INSTANCE.setLocale(new Locale("en", "US"));
                    break;
                case "be":
                    ResMan.INSTANCE.setLocale(new Locale("be", "BY"));
                    break;
                default:
                    try {
                        Var var;
                        var = parser.calc(expr);
                        printer.print(var);
                        Logger.getInstance().log("= "+ var.toString());
                        ReportDirector.addOperation(" = " + var.toString());
                    } catch (CalcException e) {
                        System.out.println(e.getMessage());
                    }
            }
            // Var.printvar();
            Var.sortVar();
        }
    }
}