package by.it.degtyaryov.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

// TODO: сделать очередь в магазине не статическую
class Queue {

    public static final int QUEUE_SIZE = 30;

    private final static BlockingDeque<Buyer> QUEUE = new LinkedBlockingDeque<>(QUEUE_SIZE);

    public static void add(Buyer buyer) {
        try {
            QUEUE.putLast(buyer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Buyer get() {
        if (hasPensioner()) {
            return getFirstPensioner();
        }
        return QUEUE.pollFirst();
    }

    public static int size() {
        return QUEUE.size();
    }

    private static Buyer getFirstPensioner() {
        for (Buyer buyer : QUEUE) {
            if (buyer.isPensioner()) {
                QUEUE.remove(buyer);
                return buyer;
            }
        }
        return null;
    }

    private static boolean hasPensioner() {
        for (Buyer buyer : QUEUE) {
            if (buyer.isPensioner()) {
                return true;
            }
        }
        return false;
    }
}
