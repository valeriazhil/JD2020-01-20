package by.it.degtyaryov.calc;

import by.it.degtyaryov.calc.i18n.ResManager;
import by.it.degtyaryov.calc.i18n.TextResource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

class ConsoleRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression;
        Parser parser = new Parser();
        Printer printer = new Printer();
        ResManager res = ResManager.INSTANCE;

        try {
            Var.loadVars();
        } catch (FileNotFoundException e) {
            Logger.logger.log(res.get(TextResource.NO_SAVED_VARS));
            System.out.println(res.get(TextResource.NO_SAVED_VARS));
        } catch (IOException | CalcException e) {
            Logger.logger.log(e.getMessage());
            System.out.println(e.getMessage());
        }


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
                    System.out.println(ru.getDisplayLanguage());
                    continue;
                case "en":
                    Locale en = new Locale("en");
                    res.setLocale(en);
                    System.out.println(en.getDisplayLanguage());
                    continue;
                default:
                    try {
                        Var result = parser.calc(expression);
                        printer.print(result);
                        Logger.logger.log(String.format(res.get(TextResource.EXPRESSION), expression, result));
                    } catch (CalcException e) {
                        System.out.println(e.getMessage());
                        Logger.logger.log(e.getMessage());
                    }
                    break;
            }
        }
    }
}
