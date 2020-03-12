package by.it.bunkov.jd02_01;

import java.util.*;

class Helper {

    private static final Random RANDOM  = new Random();
    public static int buyersCount = 0;
    private static int speed = 1;
    private static int steps = 120;
    private static int minTimeToChoose = 500;
    private static int maxTimeToChoose = 2000;
    private static int goOutTime = 500;
    private static int minBuyersByStep = 0;
    private static int maxBuyersByStep = 2;
    private static int minGoods = 1;
    private static int maxGoods = 4;
    private static double pensionerDecelerationRate = 1.5;
    private static List<Good> goods = new ArrayList<>();
    private static Map<Good, Double> priceList = new HashMap<>();

    public static void generatePriceList() {
        for (int i = 0; i < 10; i++) {
            Good good = new Good("Good " + (i + 1));
            goods.add(good);
            priceList.put(good, random(100, 1000) / 100.0);
        }
    }

    public static Map<Good, Double> getPriceList() {
        return priceList;
    }

    public static Good chooseGood() {
        return goods.get(new Random().nextInt(goods.size()));
    }

    private static int random(int min, int max) {
        return RANDOM.nextInt(max - min + 1) + min;
    }

    public static int getBuyersCountByStep() {
        return random(minBuyersByStep, maxBuyersByStep);
    }

    public static int getBuyersCountByStep(int step) {
        int count = buyersCount;
        step %= 60;
        if (step <= 30 && count < step + 10) {
            return Helper.random(0, step + 10 - count);
        } else if (step > 30 && count < 70 - step) {
            return Helper.random(0, 70 - step - count);
        } else {
            return 0;
        }
    }

    public static int getTimeToChoose() {
        return random(minTimeToChoose, maxTimeToChoose) / speed;
    }

    public static int getGoodsCount() {
        return random(minGoods, maxGoods);
    }

    public static double getPensionerDecelerationRate() {
        return pensionerDecelerationRate;
    }

    public static int getSpeed() {
        return speed;
    }

    public static void setSpeed(int speed) {
        Helper.speed = speed;
    }

    public static int getSteps() {
        return steps;
    }

    public static int getGoOutTime() {
        return goOutTime / speed;
    }



}

