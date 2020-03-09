package by.it.akhmelev.calc20;


import by.it.akhmelev.calc20.translate.ResMan;

import java.util.Locale;
import java.util.Scanner;

class ConsoleRunner {


    public static void main(String[] args) {
        ResMan man = ResMan.INSTANCE;
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        Var.loadVars();
        while (true) {
            String expression = scanner.nextLine();
            if (expression.equals("end")) {
                break;
            }
            switch (expression) {
                case "ru":
                    Locale locale = new Locale("ru");
                    man.setLocale(locale);
                    printer.message(locale.getDisplayLanguage());
                    break;
                case "en":
                    man.setLocale(Locale.ENGLISH);
                    printer.message(Locale.ENGLISH.getDisplayLanguage());
                    break;
                default:
                    try {
                        Var var = parser.calc(expression);
                        printer.print(var);
                    } catch (CalcException e) {
                        printer.message(e.getMessage());
                    }
            }

        }
    }
}
