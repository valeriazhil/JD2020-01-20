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

        setArgsLocale(args, res);
        welcomeUser(res);
        printCurrentDate(res.getLocale());
        loadSavedVars(res);

        while (true) {
            expression = scanner.nextLine();
            switch (expression) {
                case "end":
                    return;
                case "printvar":
                    printer.printVariables(false);
                    break;
                case "sortvar":
                    printer.printVariables(true);
                    break;
                case "ru":
                    Locale ru = new Locale("ru");
                    res.setLocale(ru);
                    logger.log(ru.getDisplayLanguage());
                    System.out.println(ru.getDisplayLanguage());
                    continue;
                case "en":
                    Locale en = new Locale("en");
                    res.setLocale(en);
                    logger.log(en.getDisplayLanguage());
                    System.out.println(en.getDisplayLanguage());
                    continue;
                case "be":
                    Locale be = new Locale("be");
                    res.setLocale(be);
                    logger.log(be.getDisplayLanguage());
                    System.out.println(be.getDisplayLanguage());
                    continue;
                default:
                    try {
                        Var result = parser.calc(expression);
                        printer.print(result);
                        logger.log(String.format(res.get(TextResource.EXPRESSION), expression, result));
                    } catch (CalcException e) {
                        System.out.println(e.getMessage());
                        logger.log(e.getMessage());
                    }
                    break;
            }
        }
    }

    private static void loadSavedVars(ResManager res) {
        try {
            Var.loadVars();
        } catch (FileNotFoundException e) {
            logger.log(res.get(TextResource.NO_SAVED_VARS));
            System.out.println(res.get(TextResource.NO_SAVED_VARS));
        } catch (IOException | CalcException e) {
            logger.log(e.getMessage());
            System.out.println(e.getMessage());
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

    private static void setArgsLocale(String[] args, ResManager res) {
        if (args.length == 1) {
            Locale defLocale = new Locale(args[0]);
            res.setLocale(defLocale);
        }
    }
}
