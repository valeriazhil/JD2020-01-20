package by.it.zhuravaskarabahataya.jd01_13;
//Костыли???
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// Нужно написать в TaskC программу, которая будет вводить вещественные числа с
//консоли, после каждой ошибки программа делает паузу в 100 мс и выводит накопленные числа в
//обратном порядке.
// Используйте Scanner, но он должен создаваться только один раз и обязательно в методе main.
// Код по чтению чисел с клавиатуры должен быть в методе static void readData().
// Если пользователь ввёл какой-то текст, вместо ввода числа, то метод readData() должен перехватить
//исключение, сделать паузу Thread.sleep(100) и вывести на экран все ранее введенные числа.
// Числа нужно выводить без форматирования, через пробел, в порядке обратном вводу.
// После 5 допущенных ошибок программа должна завершиться, пробрасывая ошибку в JVM

class TaskC {
    static Scanner sc;

    public static void main(String[] args) throws InterruptedException {
        sc = new Scanner(System.in);
        while (true) {
            readData();
        }
    }

    static void readData() throws InterruptedException {
        int counterOfExceptions = 0;
        ArrayList<Double> list = new ArrayList<>();
        while (counterOfExceptions<7){
            try{
                double number = Double.parseDouble(sc.nextLine());
                list.add(number);
            }
            catch (NumberFormatException e) {
                Thread.sleep(100);
                counterOfExceptions++;
                Collections.reverse(list);
                for (Double aDouble : list) {
                    System.out.print(aDouble + " ");
                }
                System.out.println();
                Collections.reverse(list);
                if (counterOfExceptions == 5){
                    throw e;
                }
            }
        }
    }
}
