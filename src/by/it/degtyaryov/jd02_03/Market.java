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

    // TODO: сделать общую выручку не статической, а для каждого магазина отдельно
    private static volatile double TOTAL_INCOME = 0;

    private BuyerManager buyerManager = new BuyerManager();
    private CashierManager cashierManager = new CashierManager(this);

    public static synchronized void addToTotalIncome(double sum) {
        TOTAL_INCOME += sum;
    }

    public static synchronized double getTotalIncome() {
        return TOTAL_INCOME;
    }

    public void start() {
        System.out.println("Market is opened.");
        int timer = 0;
        cashierManager.launchCashiers();
        while (!buyerManager.allBuyersComplete()) {
            buyerManager.check(++timer);
            cashierManager.check();
            Helper.sleep(1000);
            System.out.printf("Time: %d. Now in market: %d buyers.%n", timer, buyerManager.getBuyersInMarket());
        }
        awaitTerminationCashier();
        System.out.println("Market is closed.");
    }

    private void awaitTerminationCashier() {
        try {
            while (!cashierManager.getExecutor().awaitTermination(120, TimeUnit.SECONDS))
                System.out.println("long waiting...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All cashiers are closed successfully.");
    }

    public boolean isOpened() {
        return !buyerManager.allBuyersComplete();
    }
}
