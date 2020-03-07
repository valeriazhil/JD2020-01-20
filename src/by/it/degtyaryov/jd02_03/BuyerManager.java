package by.it.degtyaryov.jd02_03;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

class BuyerManager {

    private static final int MAX_BASKET = 50;
    private static final int PLAN = 100;
    private static final int BUYERS_BEGIN_MINUTE = 10;
    private static final int BUYERS_MIDDLE_MINUTE = 40;

    private static BlockingQueue<Basket> baskets = new ArrayBlockingQueue<>(MAX_BASKET);
    private final AtomicInteger buyersInMarket = new AtomicInteger();
    private final AtomicInteger buyersComplete = new AtomicInteger();
    private final Market market;

    public BuyerManager(Market market) {
        initializeBaskets();
        this.market = market;
    }

    public void check(int time) {
        if (canEnterBuyer()) {
            int buyersToEnter = getBuyerToEnterByTime(time);
            for (int i = 0; i < buyersToEnter && canEnterBuyer(); i++) {
                Buyer buyer = new Buyer(Helper.getRandomIsPensioner(), this);
                new Thread(buyer).start();
            }
        }
    }

    public void markBuyerEnter() {
        buyersInMarket.getAndIncrement();
    }

    public void markBuyerGoOut() {
        buyersComplete.getAndIncrement();
        buyersInMarket.getAndDecrement();
    }

    public int getBuyersInMarket() {
        return buyersInMarket.get();
    }

    private int getCountMustBeInMarket(int time) {
        int count;
        time %= 60; // для привязки к секунде без учета минуты
        if (time < 30)
            count = BUYERS_BEGIN_MINUTE + time;
        else
            count = BUYERS_MIDDLE_MINUTE + (30 - time);
        return count;
    }

    private int getBuyerToEnterByTime(int time) {
        int mustBeInMarket = getCountMustBeInMarket(time);
        return (getBuyersInMarket() > mustBeInMarket) ? 0 : mustBeInMarket - getBuyersInMarket();
    }

    public boolean canEnterBuyer() {
        return buyersInMarket.get() + buyersComplete.get() < PLAN;
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    public boolean allBuyersComplete() {
        return buyersComplete.get() == PLAN;
    }

    private void initializeBaskets() {
        for (int i = 1; i <= MAX_BASKET; i++) {
            Basket basket = new Basket();
            try {
                baskets.put(basket);
                System.out.printf("Created one new basket. Now there are %d baskets.%n", baskets.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Basket getBasket() {
        try {
            return baskets.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void returnBasket(Basket basket) {
        baskets.offer(basket);
        System.out.printf("Buyer return basket. We have %d free baskets.%n", baskets.size());
    }

    public Market getMarket() {
        return market;
    }
}
