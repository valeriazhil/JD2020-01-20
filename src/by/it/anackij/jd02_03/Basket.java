package by.it.anackij.jd02_03;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

class Basket {

    int capacity;
    static Semaphore basketSemaphore = new Semaphore(50);
    Map<Good, Integer> basketGoods;

    int totalPrice;

    Basket(){
        capacity = findCapacity();
        basketGoods = new HashMap<>(capacity);
    }

    int findCapacity (){
        return (int)(Math.random()*4+1);
    }

}
