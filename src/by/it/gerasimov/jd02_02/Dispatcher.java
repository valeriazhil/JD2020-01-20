package by.it.gerasimov.jd02_02;

class Dispatcher {

    private volatile static int buyersCount = 0;

    public static int getBuyersCountByStep(int step) {
        step %= 60;
        if (step < 30 && buyersCount < step + 10) {
            return Helper.random(0, 40 - buyersCount);
        } else if (buyersCount < 40 + (30 - step)) {
            return Helper.random(0, 2);
        } else {
            return 0;
        }
    }

    synchronized void increaseBuyersCount() {
        buyersCount++;
    }

    synchronized void decreaseBuyersCount() {
        buyersCount--;
    }

}
