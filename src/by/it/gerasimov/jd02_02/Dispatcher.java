package by.it.gerasimov.jd02_02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Dispatcher {

    static final Object OPEN_CASHIER_MONITOR = new Object();
    private static final int PLAN = 100;
    private volatile static int currentBuyersCount = 0;
    private volatile static int totalBuyersCount = 0;
    private volatile static int servedBuyersCount = 0;
    private volatile static int cashierCount = 0;

    private static List<Buyer> buyers = new ArrayList<>();
    private static List<Thread> cashiers = new ArrayList<>();
    private static List<Integer> count = new LinkedList<>();

    synchronized public static int getCashierCount() {
        return cashierCount;
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
        int count = currentBuyersCount;
        step %= 60;
        if (step <= 30 && count < step + 10) {
            return Helper.random(0, step + 10 - count);
        } else if (step > 30 && count < 70 - step) {
            return Helper.random(0, 70 - step - count);
        } else {
            return 0;
        }
    }

    synchronized static void increaseBuyersCount() {
        currentBuyersCount++;
        totalBuyersCount++;
    }

    synchronized static void increaseServedBuyersCount() {
        servedBuyersCount++;
    }

    public static int getCurrentBuyersCount() {
        return currentBuyersCount;
    }

    synchronized static void decreaseCurrentBuyersCount() {
        currentBuyersCount--;
    }

    static int getTotalBuyersCount() {
        return totalBuyersCount;
    }

    static boolean shopIsOpened() {
        return totalBuyersCount != PLAN;
    }

    static boolean shopIsClosed() {
        return servedBuyersCount == PLAN;
    }

    synchronized static int getServedBuyersCount() {
        return servedBuyersCount;
    }

    synchronized static void increaseCashierCount() {
        cashierCount++;
    }

    synchronized static void decreaseCashierCount() {
        cashierCount--;
    }

    public static void generateCashiers() {
        for (int i = 1; i <= 5; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            cashiers.add(thread);
            thread.start();
        }
    }

    public static void generateBuyers() {
        for (int i = 0; Dispatcher.shopIsOpened(); i++) {
            for (int j = 0; j < Dispatcher.getBuyersCountByStep(i) && Dispatcher.shopIsOpened();
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
        for (Thread cashier : cashiers) {
            try {
                cashier.join();
            } catch (InterruptedException e) {
                System.out.println("The shop don't wait " + cashier.getName());
            }
        }
        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
