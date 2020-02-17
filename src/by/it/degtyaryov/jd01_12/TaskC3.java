package by.it.degtyaryov.jd01_12;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskC3 {

    private static Deque<String> stack = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder inputLine = new StringBuilder();
        System.out.println("Для завершения ввода введите строку \"end\"");
        while (true) {
            String line = scan.nextLine();
            if (line.equals("end")) {
                break;
            }
            inputLine.append(line);
        }
        boolean isCorrect = checkCorrect(inputLine.toString());
        System.out.printf("Результат проверки текста: %s", isCorrect);
    }

    private static boolean checkCorrect(String inputLine) {
        Matcher match = Pattern.compile("[\\[\\]{}()]").matcher(inputLine);
        while (match.find()) {
            String bracket = match.group();
            if (isOpenBracket(bracket)) {
                stack.addLast(bracket);
            } else {
                if (!matchToLastBracket(bracket)) {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }

    private static boolean matchToLastBracket(String bracket) {
        if (stack.size() == 0) {
            return false;
        }
        switch (bracket) {
            case "}":
                return stack.pollLast().equals("{");
            case "]":
                return stack.pollLast().equals("[");
            case ")":
                return stack.pollLast().equals("(");
            default:
                return false;
        }
    }

    private static boolean isOpenBracket(String bracket) {
        return bracket.matches("[\\[({]");
    }
}
