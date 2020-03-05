package by.it.akhmelev.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {

    static final int K_SPEED = 100;

    private static final AtomicInteger numberBuyer = new AtomicInteger(0);
    private static final AtomicInteger buyersInMarket = new AtomicInteger(0);
    private static final AtomicInteger completeBuyers = new AtomicInteger(0);
    private static final int PLAN = 100;

    static int getNumberBuyer() {
        return numberBuyer.get();
    }

    static void newBuyer() {
        numberBuyer.getAndIncrement();
        buyersInMarket.getAndIncrement();
    }

    static void buyerLeaveTheMarket() {
        buyersInMarket.getAndDecrement();
        completeBuyers.getAndIncrement();
    }

    static boolean marketIsOpened() {
        return completeBuyers.get() + buyersInMarket.get() < PLAN;
    }

    static boolean marketClosed() {
        return PLAN == completeBuyers.get();
    }

}
