package by.it.degtyaryov.jd02_01;

import java.util.Random;

class Helper {

    private static final Random GENERATOR = new Random(11);

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int getRandom(int min, int max) {
        return GENERATOR.nextInt(max - min + 1) + min;
    }

    public static int getRandom(int max) {
        return getRandom(0, max);
    }

    public static Good getRandomGood() {
        return Market.ALL_GOODS.get(getRandom(Market.ALL_GOODS.size() - 1));
    }

    public static boolean getRandomIsPensioner() {
        return Helper.getRandom(1, 4) % 4 == 0; // every 4-th is pensioner (true)
    }
}
