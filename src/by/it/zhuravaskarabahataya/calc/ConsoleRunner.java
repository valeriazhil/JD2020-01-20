package by.it.zhuravaskarabahataya.calc;

import by.it.zhuravaskarabahataya.calc.translate.ResMan;

import java.util.Locale;
import java.util.Scanner;


class ConsoleRunner {

    private static String varsFile = FileHelper.getFilePath("vars.txt", Var.class);

    public static void main(String[] args) {
        ResMan man = ResMan.INSTANCE;
        Scanner sc = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        while (true) {
            String expr = sc.nextLine();
            if (expr.equals("end")) {
                break;
            }
            switch (expr){
                case "ru" :
                    Locale locale = new Locale("ru");
                    man.setLocale(locale);
                        break;
                case  "en":
                ResMan.INSTANCE.setLocale(new Locale("en", "US"));
            break;
                default:
            try {
                Var var;
                var = parser.calc(expr);
                printer.print(var);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
        }

        // Var.printvar();
        Var.sortVar();
    }}
}
