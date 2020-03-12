package by.it.bunkov.jd02_02;

import java.util.*;

public class Helper {
    private static final Random RANDOM = new Random();
    private static int speed = 1;
    private static final int STEPS = 120;
    private static final int MIN_TIME_TO_CHOOSE = 500;
    private static final int MAX_TIME_TO_CHOOSE = 2000;
    private static final int GO_OUT_TIME = 500;
    private static final int MIN_GOODS = 1;
    private static final int MAX_GOODS = 4;
    private static final double PENSIONER_DECELERATION_RATE = 1.5;
    private static final int MIN_TIME_OF_CASHIER_SERVICE = 2000;
    private static final int MAX_TIME_OF_CASHIER_SERVICE = 5000;
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

    static int random(int min, int max) {
        return RANDOM.nextInt(max - min + 1) + min;
    }

    public static int getTimeToChoose() {
        return random(MIN_TIME_TO_CHOOSE, MAX_TIME_TO_CHOOSE) / speed;
    }

    public static int getGoodsCount() {
        return random(MIN_GOODS, MAX_GOODS);
    }

    public static int getTimeOfCashierService() {
        return random(MIN_TIME_OF_CASHIER_SERVICE, MAX_TIME_OF_CASHIER_SERVICE) / speed;
    }

    public static double getPensionerDecelerationRate() {
        return PENSIONER_DECELERATION_RATE;
    }

    public static int getSpeed() {
        return speed;
    }

    public static void setSpeed(int speed) {
        Helper.speed = speed;
    }

    public static int getSteps() {
        return STEPS;
    }

    public static int getGoOutTime() {
        return GO_OUT_TIME / speed;
    }

}
