package by.it.dolgiy.Calc;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        String line;
        while (!(line = scanner.nextLine()).equals("end")){
            Var result = parser.calc(line);
            printer.print(result);
        }
        while ((line = scanner.nextLine()).equals("printvar")){
            Set<Map.Entry<String, Var>> entries = Var.getVars().entrySet();
            for (Map.Entry<String, Var> entry : entries) {
                System.out.println(entry.getKey()+"="+entry.getValue());
            }
        }
    }
}
