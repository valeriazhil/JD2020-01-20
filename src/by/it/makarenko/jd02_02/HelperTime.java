package by.it.makarenko.jd02_02;

import java.util.Random;

public class HelperTime {


    private static Random rnd = new Random(12);

    static void sleep(int timeout){
        try {Thread.sleep(timeout/ Dispatcher.K_SPEED);
        } catch (InterruptedException e) {
            System.err.println("Crash of thread");
        }

    }

    static int random(int min, int max){
        return rnd.nextInt(max-min+1)+min;
    }
    static int random(int max){
        return random(0, max);
    }
}
