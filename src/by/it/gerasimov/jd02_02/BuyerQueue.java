package by.it.gerasimov.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

class BuyerQueue {

    private static final Deque<Buyer> QUEUE = new LinkedList<>();

    static void add(Buyer buyer) {
        synchronized (QUEUE) {
            QUEUE.addLast(buyer);
        }
        if (BuyerQueue.getQueueSize() > 0 &&
            BuyerQueue.getQueueSize() / 5 >= Dispatcher.getCashierCount() &&
            Dispatcher.getCashierCount() < 5) {
            synchronized (Dispatcher.OPEN_CASHIER_MONITOR) {
                Dispatcher.OPEN_CASHIER_MONITOR.notify();
            }
        }
    }

    static Buyer extract() {
        synchronized (QUEUE) {
            return QUEUE.pollFirst();
        }
    }

    synchronized static int getQueueSize() {
        return QUEUE.size();
    }
}
