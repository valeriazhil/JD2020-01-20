package by.it.degtyaryov.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

class Queue {

    private final static Deque<Buyer> queue = new LinkedList<>();

    public static synchronized void add(Buyer buyer) {
        queue.addLast(buyer);
    }

    public static synchronized Buyer get() {
        return queue.pollFirst();
    }
}
