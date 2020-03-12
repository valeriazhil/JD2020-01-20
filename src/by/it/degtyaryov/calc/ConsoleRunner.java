package by.it.degtyaryov.calc;

import by.it.degtyaryov.calc.i18n.ResManager;
import by.it.degtyaryov.calc.i18n.TextResource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

class ConsoleRunner {

    private static Logger logger = Logger.getInstance();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression;
        Parser parser = new Parser();
        Printer printer = new Printer();
        ResManager res = ResManager.INSTANCE;
        Reporter reporter = new Reporter();

        setArgsLocale(args, res);
        welcomeUser(res);
        printCurrentDate(res.getLocale());
        loadSavedVars(res);

        while (true) {
            expression = scanner.nextLine();
            switch (expression) {
                case "end":
                    printReport(reporter, scanner);
                    return;
                case "printvar":
                    printer.printVariables(false);
                    break;
                case "sortvar":
                    printer.printVariables(true);
                    break;
                case "ru":
                    setLocale(res, "ru");
                    continue;
                case "en":
                    setLocale(res, "en");
                    continue;
                case "be":
                    setLocale(res, "be");
                    continue;
                default:
                    try {
                        Var result = parser.calc(expression);
                        printer.print(result);
                        reporter.addOperation(expression, result.toString());
                        logger.log(String.format(res.get(TextResource.EXPRESSION), expression, result));
                    } catch (CalcException e) {
                        reporter.addOperation(expression, e.getMessage());
                        System.out.println(e.getMessage());
                        logger.log(e.getMessage());
                    }
                    break;
            }
        }
    }

    private static void setArgsLocale(String[] args, ResManager res) {
        if (args.length == 1) {
            Locale defLocale = new Locale(args[0]);
            res.setLocale(defLocale);
        }
    }

    private static void welcomeUser(ResManager res) {
        String message = String.format(res.get(TextResource.WELCOME), res.get(TextResource.USER_NAME));
        logger.log(message);
        System.out.println(message);
    }

    private static void printCurrentDate(Locale locale) {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, locale);
        System.out.println(dateFormat.format(new Date()));
    }

    private static void loadSavedVars(ResManager res) {
        try {
            VarSaver.loadVars();
        } catch (FileNotFoundException e) {
            logger.log(res.get(TextResource.NO_SAVED_VARS));
            System.out.println(res.get(TextResource.NO_SAVED_VARS));
        } catch (IOException | CalcException e) {
            logger.log(e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    private static void printReport(Reporter reporter, Scanner scanner) {
        System.out.println(ResManager.INSTANCE.get(TextResource.FORM_REPORT));
        ReportBuilder builder = chooseReportForm(scanner);
        reporter.setReportBuilder(builder);
        reporter.buildReport();
        System.out.println(reporter.getReport());
    }

    private static void setLocale(ResManager res, String locale) {
        Locale ru = new Locale(locale);
        res.setLocale(ru);
        logger.log(ru.getDisplayLanguage());
        System.out.println(ru.getDisplayLanguage());
    }

    private static ReportBuilder chooseReportForm(Scanner scanner) {
        String input = scanner.next();
        if (input.equals("F")) {
            return new FullReportBuilder();
        } else {
            return new ShortReportBuilder();
        }
    }
}
