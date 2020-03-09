package by.it.gerasimov.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

class BuyerQueue {

    private static final BlockingDeque<Buyer> QUEUE = new LinkedBlockingDeque<>(30);
    private static final ConcurrentLinkedDeque<Buyer> PENSIONER_QUEUE = new ConcurrentLinkedDeque<>();
    private static final AtomicInteger queueSize = new AtomicInteger(0);

    static void add(Buyer buyer) {
        try {
            if (buyer.isPensioner()) {
                PENSIONER_QUEUE.addLast(buyer);
            } else {
                QUEUE.putLast(buyer);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        queueSize.incrementAndGet();
        if (BuyerQueue.getQueueSize() > 0 &&
            BuyerQueue.getQueueSize() / 5 >= Dispatcher.getCashierCount() &&
            Dispatcher.getCashierCount() < Dispatcher.getCashiers().size()) {
            synchronized (Dispatcher.OPEN_CASHIER_MONITOR) {
                Dispatcher.OPEN_CASHIER_MONITOR.notify();
            }
        }
    }

    static Buyer extract() {
        if (!PENSIONER_QUEUE.isEmpty()) {
            queueSize.decrementAndGet();
            return PENSIONER_QUEUE.pollFirst();
        } else if (!QUEUE.isEmpty()) {
            queueSize.decrementAndGet();
            return QUEUE.pollFirst();
        } else {
            return null;
        }
    }

    static int getQueueSize() {
        return queueSize.get();
    }
}
