package by.it.degtyaryov.jd02_02;

import java.io.PrintWriter;
import java.util.Arrays;

class Reporter {

    private static PrintWriter printWriter = new PrintWriter(System.out);

    private static String[] paper;

    public static synchronized void printReport(int cashierNumber, Check check) {
        String sb = getTitle() +
                getBody(cashierNumber, check) +
                getTotal(cashierNumber, check.getSum());
        printWriter.printf(sb).flush();
    }

    private static void initializeValues(int cashierNumber, String line) {
        paper = new String[CashierManager.MAX_CASHIER];
        Arrays.fill(paper, "");
        paper[cashierNumber] = line;
    }

    private static String getTitle() {
        return String.format("|%15s|%15s|%15s|%15s|%15s|%n", "Cashier №0", "Cashier №1", "Cashier №2", "Cashier №3", "Cashier №4");
    }

    private static String getBody(int cashierNumber, Check check) {
        StringBuilder string = new StringBuilder();
        for (Good good : check.getGoods()) {
            String goodFormat = good.getName() + " +" + good.getPrice();
            initializeValues(cashierNumber, goodFormat);
            String line = String.format("|%-15s|%-15s|%-15s|%-15s|%-15s|%n", paper[0], paper[1], paper[2], paper[3], paper[4]);
            string.append(line);
        }
        return string.toString();
    }

    private static String getTotal(int cashierNumber, double sum) {
        String sumLineFormat = String.format("TOTAL: %.2f", sum);
        initializeValues(cashierNumber, sumLineFormat);
        return String.format("|%15s|%15s|%15s|%15s|%15s|%n", paper[0], paper[1], paper[2], paper[3], paper[4]);
    }
}
