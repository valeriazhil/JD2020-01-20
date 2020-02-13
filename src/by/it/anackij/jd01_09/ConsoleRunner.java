package by.it.anackij.jd01_09;


import java.util.Scanner;

 class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        while (true){
           String  expession =scanner.nextLine();
                    if (expession.equals("end"))
                        break;
            Var var = parser.calc(expession);
            printer.print(var);

        }
    }
}
