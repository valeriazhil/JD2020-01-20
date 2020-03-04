package by.it.gerasimov.jd02_02;

class Dispatcher {

    private static final int PLAN = 100;
    private volatile static int currentBuyersCount = 0;
    private volatile static int totalBuyersCount = 0;
    private volatile static int servedBuyersCount = 0;
    private volatile static int cashierCount = 0;

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

    static boolean needCashier() {
        return false;
    }
}
