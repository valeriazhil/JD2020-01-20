package by.it.degtyaryov.jd02_02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Market {

    public static final List<Good> ALL_GOODS = new ArrayList<>(Arrays.asList(
            new Good("Milk", 2.1),
            new Good("Bread", 0.7),
            new Good("Beer", 1.3),
            new Good("Sweets", 8.99),
            new Good("Eggs", 2.0),
            new Good("Water", 1.0)));

    private List<Thread> threads = new ArrayList<>(1000);

    public void start() {
        System.out.println("Market is opened.");
        int timer = 0;
        startCashier(5);
        //while (Dispatcher.marketIsOpened()) {
        while (!Dispatcher.allBuyersComplete()) {
            runBuyers(timer++);
            CashierDispatcher.checkStatus();
            System.out.printf("Time: %d. Now in market: %d buyers.%n", timer, Dispatcher.getBuyersInMarket());
            Helper.sleep(1000);
        }
    }

    private void runBuyers(int timer) {
        int buyersToEnter = Dispatcher.getBuyerToEnterByTime(timer);
        for (int i = 0; i < buyersToEnter && Dispatcher.marketIsOpened(); i++) {
            Buyer buyer = new Buyer(Dispatcher.getBuyersCounter(), Helper.getRandomIsPensioner());
            threads.add(buyer);
            buyer.start();
        }
    }

    private void startCashier(int count) {
        for (int i = 0; i < count; i++) {
            Cashier cashier = new Cashier(i);
            threads.add(cashier);
            cashier.start();
        }
    }

    public void end() {
        for (Thread buyer : threads) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Marked is closed.");
    }
}
