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

    public static synchronized int size() {
        return queue.size();
    }

    private static synchronized Buyer getFirstPensioner() {
        for (Buyer buyer : queue) {
            if (buyer.isPensioner()) {
                queue.remove(buyer);
                return buyer;
            }
        }
        return null;
    }

    private static synchronized boolean hasPensioner() {
        for (Buyer buyer : queue) {
            if (buyer.isPensioner()) {
                return true;
            }
        }
        return false;
    }

/*    public static synchronized void printQueue() {
        System.out.print("In queue: ");
        for (Buyer buyer : queue) {
            System.out.print(buyer + " ");
        }
        System.out.println();
    }*/
}
