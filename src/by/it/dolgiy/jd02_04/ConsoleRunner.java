package by.it.dolgiy.jd02_04;

import java.util.Scanner;

class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        Var.loadVars();
        String line;
        while (!(line = scanner.nextLine()).equals("end")){
            try {
                if (line.equals("printvar")){
                    Var.printVar();
                }
                if (line.equals("sortvar")){
                    Var.sortVar();
                }
                Var result = parser.calc(line);
                printer.print(result);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
