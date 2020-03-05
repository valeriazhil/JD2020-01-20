package by.it.gerasimov.jd02_03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {

    static final Object OPEN_CASHIER_MONITOR = new Object();
    private static final int PLAN = 100;
    private static final AtomicInteger currentBuyersCount = new AtomicInteger(0);
    private static final AtomicInteger totalBuyersCount = new AtomicInteger(0);
    private static final AtomicInteger servedBuyersCount = new AtomicInteger(0);
    private static final AtomicInteger cashierCount = new AtomicInteger(0);

    private static List<Buyer> buyers = new ArrayList<>();
    private static List<Cashier> cashiers = new ArrayList<>();
    private static List<Integer> count = new LinkedList<>();

    private static BlockingQueue<Basket> baskets = new ArrayBlockingQueue<>(50);

    public static void generateBaskets() {
        for (int i = 0; i < 50; i++) {
            Basket basket = new Basket();
            try {
                baskets.put(basket);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static Basket getBasket() throws InterruptedException {
        return baskets.take();
    }

    public static List<Cashier> getCashiers() {
        return cashiers;
    }

    public static int getCashierCount() {
        return cashierCount.get();
    }

    public static void printDynamics() {
        for (int i = 0; i < count.size(); i++) {
            System.out.printf("%2d ", count.get(i));
            if ((i + 1) % 60 == 0) {
                System.out.println();
            }
        }
    }

    public static int getBuyersCountByStep(int step) {
        int count = currentBuyersCount.get();
        step %= 60;
        if (step <= 30 && count < step + 10) {
            return Helper.random(0, step + 10 - count);
        } else if (step > 30 && count < 70 - step) {
            return Helper.random(0, 70 - step - count);
        } else {
            return 0;
        }
    }

    static void increaseBuyersCount() {
        currentBuyersCount.getAndIncrement();
        totalBuyersCount.getAndIncrement();
    }

    static void increaseServedBuyersCount() {
        servedBuyersCount.getAndIncrement();
    }

    public static int getCurrentBuyersCount() {
        return currentBuyersCount.get();
    }

    static void decreaseCurrentBuyersCount() {
        currentBuyersCount.getAndDecrement();
    }

    static int getTotalBuyersCount() {
        return totalBuyersCount.get();
    }

    static boolean shopIsOpened() {
        return totalBuyersCount.get() != PLAN;
    }

    static boolean shopIsClosed() {
        return servedBuyersCount.get() == PLAN;
    }

    static void increaseCashierCount() {
        cashierCount.getAndIncrement();
    }

    static void decreaseCashierCount() {
        cashierCount.getAndDecrement();
    }

    public static void generateCashiers() {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 5; i++) {
            Cashier cashier = new Cashier(i);
            cashiers.add(cashier);
            pool.execute(cashier);
        }
        pool.shutdown();
    }

    public static void generateBuyers() {
        for (int i = 0; Dispatcher.shopIsOpened(); i++) {
            for (int j = 0; j < Dispatcher
                .getBuyersCountByStep(i) && Dispatcher.shopIsOpened();
                j++) {
                Buyer buyer = new Buyer();
                buyers.add(buyer);
                buyer.start();
            }
            count.add(Dispatcher.getCurrentBuyersCount());
            try {
                Thread.sleep(1000 / Helper.getSpeed());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void joinAll() {
        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                System.out.println("The shop don't wait " + buyer.getName());
            }
        }
    }

    public static void putBasket(Basket basket) {
        try {
            basket.clear();
            baskets.put(basket);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
