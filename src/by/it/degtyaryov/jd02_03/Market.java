package by.it.degtyaryov.jd02_03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

class Market {

    public static final List<Good> ALL_GOODS = new ArrayList<>(Arrays.asList(
            new Good("Milk", 2.1),
            new Good("Bread", 0.7),
            new Good("Beer", 1.3),
            new Good("Sweets", 8.99),
            new Good("Eggs", 2.0),
            new Good("Water", 1.0)));

    private volatile double TOTAL_INCOME = 0;

    private Queue queue = new Queue();
    private BuyerManager buyerManager = new BuyerManager(this);
    private CashierManager cashierManager = new CashierManager(this);

    public void start() {
        System.out.println("Market is opened.");
        int timer = 0;
        cashierManager.createCashiers();
        while (!buyerManager.allBuyersComplete()) {
            buyerManager.check(++timer);
            cashierManager.check();
            Helper.sleep(1000);
            System.out.printf("Time: %d. Now in market: %d buyers.%n", timer, buyerManager.getBuyersInMarket());
        }
        awaitTerminationCashiers();
        System.out.println("Market is closed.");
    }

    private void awaitTerminationCashiers() {
        try {
            while (!cashierManager.getExecutor().awaitTermination(120, TimeUnit.SECONDS))
                System.out.println("Waiting for closing cashiers.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All cashiers are closed successfully.");
    }

    public synchronized void addToTotalIncome(double sum) {
        TOTAL_INCOME += sum;
    }

    public synchronized double getTotalIncome() {
        return TOTAL_INCOME;
    }

    public Queue getQueue() {
        return queue;
    }

    public boolean isOpened() {
        return !buyerManager.allBuyersComplete();
    }
}
