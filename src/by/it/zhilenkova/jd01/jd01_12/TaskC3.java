package by.it.zhilenkova.jd01.jd01_12;

import java.util.*;

/*
TaskC3. В консоль вводится строка, состоящая из выражений и символов «(», «)»,
«[», «]», «{», «}».
 Проверьте и выведите в консоль корректность расстановки скобок
(true или false) с помощью коллекций.
 */

public class TaskC3 {

    private static List<Character> openBr = new ArrayList<>(Arrays.asList('(', '{', '['));
    private static String REGEXP = "[^{}\\[\\]()]+";
    public static void main(String[] args) {

        String s = "()";

        Scanner scanner = new Scanner(System.in);
       // String line = scanner.nextLine();
        String line = "({aef[afae]f})";
        System.out.println("Ваша строка - " + line);

        String string = line.replaceAll(REGEXP, "");
        System.out.println(string+"-------мой");

        System.out.println(check(string));


    }

    private static boolean check(String line) {
        char[] brackets = line.toCharArray();

        LinkedList<Character> stack = new LinkedList<>();

        for(char ch : brackets ){
            System.out.println(stack+"start=======");
            if(openBr.contains(ch)){
                switch (ch){
                    case '(': stack.addLast(')'); break;
                    case '{': stack.addLast('}'); break;
                    case '[': stack.addLast(']'); break;
                }
                System.out.println(stack+"from switch==========");

            } else {
                if(stack.isEmpty()){
                    return false;
                } else if (!stack.peekLast().equals(ch)){
                    return false;
                }
                stack.removeLast();
            }
        }

        return stack.isEmpty();
    }
}