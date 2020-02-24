package by.it.degtyaryov.jd02_01;

import java.util.Random;

class Helper {

    private static final Random generator = new Random(11);

    static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static int getRandom(int min, int max) {
        return generator.nextInt(max - min + 1) + min;
    }

    static int getRandom(int max) {
        return getRandom(0, max);
    }
}
