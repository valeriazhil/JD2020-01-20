package by.it.akhmelev.calc11;

import java.util.Scanner;

class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        while (true){
            String expression = scanner.nextLine();
            if (expression.equals("end"))
                break;
            Var var = parser.calc(expression);
            printer.print(var);
        }

    }
}
