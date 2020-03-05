package by.it.degtyaryov.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

class Queue {

    private final static Deque<Buyer> queue = new LinkedList<>();

    public static synchronized void add(Buyer buyer) {
        queue.addLast(buyer);
    }

    public static synchronized Buyer get() {
        if (hasPensioner()) {
            return getFirstPensioner();
        }
        return queue.pollFirst();
    }

    public static int size() {
        return queue.size();
    }

    private static Buyer getFirstPensioner() {
        for (Buyer buyer : queue) {
            if (buyer.isPensioner()) {
                queue.remove(buyer);
                return buyer;
            }
        }
        return null;
    }

    private static boolean hasPensioner() {
        for (Buyer buyer : queue) {
            if (buyer.isPensioner()) {
                return true;
            }
        }
        return false;
    }
}
