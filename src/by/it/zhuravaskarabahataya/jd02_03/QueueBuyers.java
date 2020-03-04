package by.it.zhuravaskarabahataya.jd02_03;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class QueueBuyers {

    private static final BlockingDeque<Buyer> QUEUE_BUYERS = new LinkedBlockingDeque<>(30);

    static void add(Buyer buyer) {
        try {
            QUEUE_BUYERS.putLast(buyer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static int getQueueLength() {
        synchronized (QUEUE_BUYERS) {
            return QUEUE_BUYERS.size();
        }
    }

    static Buyer extract() {
            return QUEUE_BUYERS.pollFirst();
    }

    static void print() {
        synchronized (QUEUE_BUYERS) {
            System.out.println("QUEUE");
            for (Buyer queueBuyer : QUEUE_BUYERS) {
                System.out.print(queueBuyer + " ");
            }
            System.out.println();
        }
    }

}
