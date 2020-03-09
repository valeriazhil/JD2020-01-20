package by.it.degtyaryov.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

class CashierManager {

    public static volatile double TOTAL_INCOME = 0;

    public static final int MAX_CASHIER = 5;
    private static final int BUYERS_PER_CASHIER = 5;

    private static volatile int workCashiers = 0;
    private static Deque<Cashier> PAUSE_CASHIERS = new LinkedList<>();
    private static Deque<Cashier> OPENED_CASHIERS = new LinkedList<>();

    public static void checkStatus() {
        int queueSize = Queue.size();
        int mustBeOpenCashier = getCashiersMustBeOpened(queueSize);
        System.out.printf("DISPATCHER: now in queue %d buyers, working cashiers - %d.%n", Queue.size(), workCashiers);
        if (mustBeOpenCashier > workCashiers) {
            if (workCashiers < 5) {
                System.out.printf("DISPATCHER: need to open one more cashier.%n");
                startCashier();
            }
        } else if (mustBeOpenCashier < workCashiers) {
            System.out.printf("DISPATCHER: need to close one cashier.%n");
            stopCashier();
        }
    }

    public static synchronized void cashierInPause(Cashier cashier) {
        PAUSE_CASHIERS.addLast(cashier);
    }

    private static synchronized void startCashier() {
        workCashiers++;
        Cashier cashierToOpen = PAUSE_CASHIERS.pollFirst();
        OPENED_CASHIERS.addFirst(cashierToOpen);
        if (cashierToOpen != null) {
            cashierToOpen.openCash();
        }
    }

    private static synchronized void stopCashier() {
        workCashiers--;
        Cashier cashierToClose = OPENED_CASHIERS.pollFirst();
        PAUSE_CASHIERS.addFirst(cashierToClose);
        if (cashierToClose != null) {
            cashierToClose.closeCash();
        }
    }

    private static int getCashiersMustBeOpened(int queueSize) {
        return (queueSize / BUYERS_PER_CASHIER) + 1;
    }

    public static synchronized void addToTotalIncome(double sum) {
        TOTAL_INCOME += sum;
    }

    public static synchronized double getTotalIncome() {
        return TOTAL_INCOME;
    }
}
