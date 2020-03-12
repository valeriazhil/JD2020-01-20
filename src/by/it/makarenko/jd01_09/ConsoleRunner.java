package by.it.makarenko.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Parser parser = new Parser();
        Printer printer = new Printer();

        while (true){
            String exp = sc.nextLine();
            if (exp.equals("end")){
                break;
            }
            Var result = parser.calc(exp);
            printer.print(result);
        }

    }
}
