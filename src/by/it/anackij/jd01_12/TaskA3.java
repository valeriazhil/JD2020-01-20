package by.it.anackij.jd01_12;

//TaskA3. В main класса TaskA3 вводите список чисел с клавиатуры до ввода слова “end”.
//  Переставьте отрицательные элементы списка чисел в конец, а положительные — в начало списка,
// сохраняя их порядок относительно друг друга.
//  Выведите список на консоль методом коллекции toString().

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TaskA3 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String word;
        int position = 0;
        while ( !(word = sc.nextLine()).equals("end")) {
            int value = Integer.valueOf(word);
            if (value>0) {
                numbers.add(position++, value);
            }
            else if (value==0){
                numbers.add(position, value);
            }
            else if (value<0){
                numbers.add(value);
            }
        }
        System.out.println(numbers);

    }


}


