package by.it.lomazki.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {
    static final int K_SPEED = 100;

    static final AtomicInteger numberBuyers = new AtomicInteger(1);
    private static final AtomicInteger buyersInMarket = new AtomicInteger(0);
    private static final AtomicInteger completeBuyers = new AtomicInteger(0);
    private static final int PLAN = 100;

     static void newBuyer() {
        numberBuyers.getAndIncrement();
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
