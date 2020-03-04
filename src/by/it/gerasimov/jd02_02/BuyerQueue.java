package by.it.gerasimov.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

class BuyerQueue {

    private static final Deque<Buyer> QUEUE = new LinkedList<>();

    static void add(Buyer buyer) {
        synchronized (QUEUE) {
            QUEUE.addLast(buyer);
        }
    }

    static Buyer extract() {
        synchronized (QUEUE) {
            return QUEUE.pollFirst();
        }
    }
}
