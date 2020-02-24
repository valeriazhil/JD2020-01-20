package by.it.gerasimov.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskC3 {

    private static Map<Character, Character> brackets = new HashMap<>();

    static {
        brackets.put('(', ')');
        brackets.put('[', ']');
        brackets.put('{', '}');
    }

    private static boolean checkBrackets(CharSequence text) {
        Deque<Character> chars = new LinkedList<>();
        Matcher m = Pattern.compile("[(){}\\[\\]]").matcher(text);
        while (m.find()) {
            Character c = m.group().charAt(0);
            if (brackets.containsKey(c)) {
                chars.add(c);
            } else if (!brackets.get(chars.pollLast()).equals(c)) {
                return false;
            }
        }
        return chars.size() == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String text = scanner.nextLine();
            if (text.equals("end")) {
                break;
            } else {
                System.out.println(checkBrackets(text));
            }
        }
    }
}
