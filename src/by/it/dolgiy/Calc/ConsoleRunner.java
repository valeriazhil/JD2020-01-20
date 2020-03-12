package by.it.dolgiy.Calc;



import by.it.dolgiy.Calc.translate.ResMan;

import java.util.Locale;
import java.util.Scanner;

class ConsoleRunner {
    public static void main(String[] args) {
        Logger.startWriteReport();
        ResMan man = ResMan.INSTANCE;
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        Var.loadVars();
        String line;
        while (true){
            try {
                line = scanner.nextLine();
                if (line.equals("ru")){
                    Locale locale = new Locale("ru","RU");
                    man.setLocale(locale);
                    printer.message(locale.getDisplayLanguage());
                    continue;
                }
                if (line.equals("be")){
                    Locale locale = new Locale("be","BY");
                    man.setLocale(locale);
                    printer.message(locale.getDisplayLanguage());
                    continue;
                }
                if (line.equals("en")){
                    Locale locale = new Locale("en","US");
                    man.setLocale(locale);
                    printer.message(locale.getDisplayLanguage());
                    continue;
                }
                if (line.equals("printvar")){
                    Var.printVar();
                    continue;
                }
                if (line.equals("sortvar")){
                    Var.sortVar();
                    continue;
                }
                if (line.equals("end")){
                    Logger.endWriteReport();
                    Logger.printLog(Logger.logs);
                    break;
                }
                Var result = parser.calc(line);
                printer.print(result);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
