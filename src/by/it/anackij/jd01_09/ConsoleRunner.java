package by.it.anackij.jd01_09;


import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        while (true){
           String  expesion =scanner.nextLine();
                    if (expesion.equals("end"))
                        break;
            Var var = parser.calc(expesion);
            printer.print(var);

        }
    }
}
