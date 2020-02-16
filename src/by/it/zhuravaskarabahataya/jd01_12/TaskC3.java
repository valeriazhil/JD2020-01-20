package by.it.zhuravaskarabahataya.jd01_12;

import java.util.*;

// TaskC3. В консоль вводится строка, состоящая из выражений и символов «(», «)», «[», «]», «{», «}».
//  Проверьте и выведите в консоль корректность расстановки скобок (true или false) с помощью коллекций.
class TaskC3 {
    public static void main(String[] args) {
        Map<String, Integer> brackets = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String words = sc.nextLine();
        System.out.println(words);
        char[] charArray = words.toCharArray();
        List<Character> charList = new ArrayList<Character>();
        for (char c : charArray) {
            if (isOpenBracket(c) || isClosedBracket(c)) {
                charList.add(c);
            }
        }
        System.out.println(charList);
        System.out.println(isRight((ArrayList<Character>) charList));
    }

    static boolean isOpenBracket(Character character) {
        List<Character> openBrackets = new ArrayList<>();
        openBrackets.add('{');
        openBrackets.add('(');
        openBrackets.add('[');
        return openBrackets.contains(character);
    }

    static boolean isClosedBracket(Character character) {
        List<Character> closedBrackets = new ArrayList<>();
        closedBrackets.add('}');
        closedBrackets.add(')');
        closedBrackets.add(']');
        return closedBrackets.contains(character);
    }

    static boolean isRight(ArrayList<Character> array) {
        boolean isRight = true;

        Map<Character, Boolean> mapOfOpenBrackets = new HashMap<>();

        for (Character character : array) {
            if (isOpenBracket(character) && !mapOfOpenBrackets.containsKey(character)){
                mapOfOpenBrackets.put(character, true);

            }
        }


        return isRight;


    }
}
