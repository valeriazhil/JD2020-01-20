package by.it.cherkas.jd02_03;

import java.util.Formatter;
import java.util.concurrent.atomic.AtomicInteger;

class Cashier implements Runnable {

    private static final AtomicInteger totalIncome = new AtomicInteger(0);
    private final AtomicInteger income = new AtomicInteger(0);
    private String name;

    public Cashier(int number) {
        name = "Cashier #" + number;
        Dispatcher.increaseCashierCount();
    }

    private static String toCashFormat(int i) {
        Formatter f = new Formatter();
        return String.valueOf(f.format("%01d.%02d", i / 100, i % 100));
    }

    private static int getSumWithCheck(Buyer buyer, Formatter f) {
        int sum = 0;
        int price;
        f.format("-------------------------------\n");
        f.format("Check for %s:\n", buyer);
        for (Good good : buyer.getBasket().getGoods()) {
            price = Helper.getPriceList().get(good);
            f.format("%10s for %6s\n", good, toCashFormat(price));
            sum += price;
        }
        f.format("%14s %6s\n", "Total:", toCashFormat(sum));
        return sum;
    }

    private static void printCurrentIncome(Formatter f) {
        f.format("--------------------------------------------------------------------------");
        f.format("------------------------------------------------------------------------\n");
        for (Cashier cashier : Dispatcher.getCashiers()) {
            f.format("%s: %6s ", cashier.name, toCashFormat(cashier.income.get()));
        }
        f.format("In queue: % 2d Total: %6s", BuyerQueue.getQueueSize(),
            toCashFormat(totalIncome.get()));
        f.format("\n------------------------------------------------------------------------");
        f.format("--------------------------------------------------------------------------");
        System.out.println(f);
    }

    @Override
    public String toString() {
        return name;
    }

    private void serve(Buyer buyer) {
        System.out.println(name + " started serving " + buyer);
        try {
            Thread.sleep(Helper.getTimeOfCashierService());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Formatter check = new Formatter();
        int sum = getSumWithCheck(buyer, check);
        totalIncome.addAndGet(sum);
        income.addAndGet(sum);
        System.out.printf("%s ended serving %s with sum: %6s\n", name, buyer, toCashFormat(sum));
        Dispatcher.increaseServedBuyersCount();
        printCurrentIncome(check);
    }

    @Override
    public void run() {
        System.out.println(name + " opened");
        while (!Dispatcher.shopIsClosed()) {
            Buyer buyer = BuyerQueue.extract();
            if (buyer != null) {
                synchronized (buyer.getQueueMonitor()) {
                    serve(buyer);
                    buyer.getQueueMonitor().notify();
                }
            } else {
                synchronized (Dispatcher.OPEN_CASHIER_MONITOR) {
                    try {
                        System.out.println(name + " temporary closed");
                        Dispatcher.decreaseCashierCount();
                        Dispatcher.OPEN_CASHIER_MONITOR.wait();
                        Dispatcher.increaseCashierCount();
                        System.out.println(name + " temporary opened");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println(name + " closed");
        synchronized (Dispatcher.OPEN_CASHIER_MONITOR) {
            Dispatcher.OPEN_CASHIER_MONITOR.notifyAll();
        }
    }
}