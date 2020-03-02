package by.it.degtyaryov.jd02_02;

class Dispatcher {

    private static final int BUYERS_BEGIN_MINUTE = 10;
    private static final int BUYERS_MIDDLE_MINUTE = 40;
    private static final int PLAN = 100;

    private static volatile int buyersCounter;
    private static volatile int buyersInMarket;
    private static volatile int buyersComplete;

    public static synchronized void newBuyerInMarket() {
        buyersCounter++;
        buyersInMarket++;
    }

    public static synchronized void buyerLeaveMarket() {
        buyersComplete++;
        buyersInMarket--;
    }

    public static int getBuyersCounter() {
        return buyersCounter;
    }

    public static int getBuyersInMarket() {
        return buyersInMarket;
    }

    public static int getBuyerToEnterByTime(int time) {
        int mustBeInMarket = Dispatcher.getCountMustBeInMarket(time);
        return (Dispatcher.getBuyersInMarket() > mustBeInMarket) ?
                0 : mustBeInMarket - Dispatcher.getBuyersInMarket();
    }

    private static int getCountMustBeInMarket(int time) {
        int count;
        time %= 60; // для привязки к секунде без учета минуты
        if (time < 30)
            count = BUYERS_BEGIN_MINUTE + time;
        else
            count = BUYERS_MIDDLE_MINUTE + (30 - time);
        return count;
    }

    public static boolean marketIsOpened() {
        return buyersInMarket + buyersComplete < PLAN;
    }

    public static boolean marketIsClosed() {
        return buyersComplete == PLAN;
    }
}
