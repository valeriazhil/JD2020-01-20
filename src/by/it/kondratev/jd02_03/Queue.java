package by.it.kondratev.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;


class Queue {

    public static final int QUEUE_SIZE = 30;

    private final BlockingDeque<Buyer> QUEUE = new LinkedBlockingDeque<>(QUEUE_SIZE);

    public void add(Buyer buyer) {
        try {
            QUEUE.putLast(buyer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Buyer get() {
        if (hasPensioner()) {
            return getFirstPensioner();
        }
        return QUEUE.pollFirst();
    }

    private boolean hasPensioner() {
        for (Buyer buyer : QUEUE) {
            if (buyer.isPensioner()) {
                return true;
            }
        }
        return false;
    }

    private Buyer getFirstPensioner() {
        for (Buyer buyer : QUEUE) {
            if (buyer.isPensioner()) {
                QUEUE.remove(buyer);
                return buyer;
            }
        }
        return null;
    }

    public int size() {
        return QUEUE.size();
    }
}
