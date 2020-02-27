package by.it.gerasimov.jd02_01;

import java.util.Random;

class Helper {

    private static int speed = 1;
    private static int steps = 120;
    private static int minTimeToChoose = 500 / speed;
    private static int maxTimeToChoose = 2000 / speed;
    private static int goOutTime = 500 / speed;
    private static int minBuyersByStep = 0;
    private static int maxBuyersByStep = 2;
    private static int minGoods = 1;
    private static int maxGoods = 4;
    private static double pensionerDecelerationRate = 1.5;
    private static final Random RANDOM = new Random();

    private static int random(int min, int max) {
        return RANDOM.nextInt(max - min + 1) + min;
    }

    public static int getBuyersCountByStep() {
        return random(minBuyersByStep, maxBuyersByStep);
    }

    public static int getTimeToChoose() {
        return random(minTimeToChoose, maxTimeToChoose);
    }

    public static int getGoodsCount() {
        return random(minGoods, maxGoods);
    }

    public static double getPensionerDecelerationRate() {
        return pensionerDecelerationRate;
    }

    public static void setPensionerDecelerationRate(double pensionerDecelerationRate) {
        Helper.pensionerDecelerationRate = pensionerDecelerationRate;
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

    public static void setSteps(int steps) {
        Helper.steps = steps;
    }

    public static int getMinTimeToChoose() {
        return minTimeToChoose;
    }

    public static void setMinTimeToChoose(int minTimeToChoose) {
        Helper.minTimeToChoose = minTimeToChoose;
    }

    public static int getMaxTimeToChoose() {
        return maxTimeToChoose;
    }

    public static void setMaxTimeToChoose(int maxTimeToChoose) {
        Helper.maxTimeToChoose = maxTimeToChoose;
    }

    public static int getGoOutTime() {
        return goOutTime;
    }

    public static void setGoOutTime(int goOutTime) {
        Helper.goOutTime = goOutTime;
    }

    public static int getMinBuyersByStep() {
        return minBuyersByStep;
    }

    public static void setMinBuyersByStep(int minBuyersByStep) {
        Helper.minBuyersByStep = minBuyersByStep;
    }

    public static int getMaxBuyersByStep() {
        return maxBuyersByStep;
    }

    public static void setMaxBuyersByStep(int maxBuyersByStep) {
        Helper.maxBuyersByStep = maxBuyersByStep;
    }

    public static int getMinGoods() {
        return minGoods;
    }

    public static void setMinGoods(int minGoods) {
        Helper.minGoods = minGoods;
    }

    public static int getMaxGoods() {
        return maxGoods;
    }

    public static void setMaxGoods(int maxGoods) {
        Helper.maxGoods = maxGoods;
    }
}
