package by.it.bunkov.calc;

import  java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {

        Parser parser= new Parser();
        Printer printer = new Printer();
        Scanner sc = new Scanner(System.in);
                   String line;


        while (!(line =sc.nextLine()).equals("end")){

            try {
              Var  result = parser.calc(line);
                printer.print(result);
            }
            catch (CalcException e) {
                System.out.println(e.getMessage());
            }







        }


    }
}
