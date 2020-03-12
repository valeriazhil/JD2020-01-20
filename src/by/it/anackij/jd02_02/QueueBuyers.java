package by.it.anackij.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

class QueueBuyers {

    private static final Deque<Buyer> QUEUE_BUYERS = new LinkedList<>();

    static void add(Buyer buyer){
        synchronized (QUEUE_BUYERS) {
            QUEUE_BUYERS.addLast(buyer);
        }
    }

    static int getQueueLength(){
        synchronized (QUEUE_BUYERS){
            return QUEUE_BUYERS.size();
        }
    }

    static Buyer extract(){
        synchronized (QUEUE_BUYERS) {
            return QUEUE_BUYERS.pollFirst();
        }
    }

    static void print(){
        synchronized (QUEUE_BUYERS) {
            System.out.println("QUEUE");
            for (Buyer queueBuyer : QUEUE_BUYERS) {
                System.out.print(queueBuyer + " ");
            }
            System.out.println();
        }
    }

}
