package by.it.gerasimov.jd02_02;

import java.util.Formatter;

class Cashier implements Runnable {

    private String name;
    private double income = 0;

    public Cashier(int number) {
        name = "Cashier #" + number;
        Dispatcher.increaseCashierCount();
    }

    private static double getSumWithCheck(Buyer buyer, Formatter f) {
        double sum = 0;
        double price = 0;
            f.format("-------------------------------\n");
        f.format("Check for %s:\n", buyer);
        for (Good good : buyer.getBasket().getGoods()) {
            price = Helper.getPriceList().get(good);
            f.format("%10s for %5.2f\n", good, price);
            sum += price;
        }
        f.format("%14s %5.2f\n", "Total:", sum);
        return sum;
    }

    private static void printCurrentIncome(Formatter f) {
        f.format("--------------------------------------------------------------------------");
        f.format("------------------------------------------------------------------------\n");
        for (Cashier cashier : Dispatcher.getCashiers()) {
            f.format("%s: % 5.2f ", cashier.name, cashier.getIncome());
        }
        f.format("In queue: % 2d Total: % 5.2f", BuyerQueue.getQueueSize(), Dispatcher.getIncome());
        f.format("\n------------------------------------------------------------------------");
        f.format("--------------------------------------------------------------------------");
        System.out.println(f);
    }

    @Override
    public String toString() {
        return name;
    }

    synchronized public double getIncome() {
        return income;
    }

    private void serve(Buyer buyer) {
        System.out.println(name + " started serving " + buyer);
        try {
            Thread.sleep(Helper.getTimeOfCashierService());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Formatter check = new Formatter();
        double sum = getSumWithCheck(buyer, check);
        Dispatcher.addIncome(sum);
        this.income += sum;
        System.out.printf("%s ended serving %s with sum: %.2f\n", name, buyer, sum);
        Dispatcher.increaseServedBuyersCount();
        printCurrentIncome(check);
    }

    @Override
    public void run() {
        System.out.println(name + " opened");
        while (!Dispatcher.shopIsClosed()) {
            Buyer buyer = BuyerQueue.extract();
            if (buyer != null) {
                synchronized (buyer) {
                    serve(buyer);
                    buyer.notify();
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