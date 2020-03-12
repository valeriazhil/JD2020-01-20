package by.it.lomazki.jd02_02;

class Dispatcher {
    static final int K_SPEED = 100;

    static int numberBuyers = 0;

    private volatile static int buyersInMarket = 0;
    private volatile static int completeBuyers = 0;
    private static final int PLAN = 100;

    synchronized static void newBuyer() {
        numberBuyers++;
        buyersInMarket++;
    }

    synchronized static void buyerLeaveTheMarket() {
        buyersInMarket--;
        completeBuyers++;
    }

    static boolean marketIsOpened() {
        return completeBuyers + buyersInMarket < PLAN;
    }

    static boolean marketClosed() {
        return PLAN == completeBuyers;
    }

}
