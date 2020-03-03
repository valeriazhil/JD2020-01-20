package by.it.degtyaryov.jd02_02;

import java.io.PrintWriter;
import java.util.Arrays;

class Reporter {

    private static final String TITLE_FORMAT = "|%15s|%15s|%15s|%15s|%15s|%15s|%15s|%n";
    private static final String BODY_FORMAT = "|%-15s|%-15s|%-15s|%-15s|%-15s|%15s|%15s|%n";
    private static final String TOTAL_FORMAT = "|%15s|%15s|%15s|%15s|%15s|%15s|%15.2f|%n";

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
        return String.format(TITLE_FORMAT, "Cashier №0", "Cashier №1", "Cashier №2", "Cashier №3", "Cashier №4", "In queue", "Market's income");
    }

    private static String getBody(int cashierNumber, Check check) {
        StringBuilder string = new StringBuilder();
        for (Good good : check.getGoods()) {
            String goodFormat = good.getName() + " +" + good.getPrice();
            initializeValues(cashierNumber, goodFormat);
            String line = String.format(BODY_FORMAT, paper[0], paper[1], paper[2], paper[3], paper[4], "", "");
            string.append(line);
        }
        return string.toString();
    }

    private static String getTotal(int cashierNumber, double sum) {
        String sumLineFormat = String.format("TOTAL: %.2f", sum);
        initializeValues(cashierNumber, sumLineFormat);
        return String.format(TOTAL_FORMAT, paper[0], paper[1], paper[2], paper[3], paper[4], Queue.size(), CashierManager.getTotalIncome());
    }
}
