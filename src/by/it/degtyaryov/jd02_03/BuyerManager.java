package by.it.degtyaryov.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class BuyerManager {

    private static final int PLAN = 300;
    private static final int BUYERS_BEGIN_MINUTE = 30;
    private static final int BUYERS_MIDDLE_MINUTE = 80;

    private final AtomicInteger buyersInMarket = new AtomicInteger();
    private final AtomicInteger buyersComplete = new AtomicInteger();
    private final Market market;

    public BuyerManager(Market market) {
        this.market = market;
    }

    /**
     * Проверка нужно ли запускать новых покупателей
     *
     * @param time секунда, на которую происходит проверка (от значения секунды зависит количество покупателей)
     */
    public void check(int time) {
        if (canBuyerEnter()) {
            int buyersToEnter = getCountBuyerToEnter(time);
            for (int i = 0; i < buyersToEnter && canBuyerEnter(); i++) {
                Buyer buyer = new Buyer(Helper.getRandomIsPensioner(), this);
                new Thread(buyer).start();
            }
        }
    }

    private boolean canBuyerEnter() {
        return buyersInMarket.get() + buyersComplete.get() < PLAN;
    }

    private int getCountBuyerToEnter(int time) {
        int mustBeInMarket = getCountMustBeInMarket(time);
        return (getBuyersInMarket() > mustBeInMarket) ? 0 : mustBeInMarket - getBuyersInMarket();
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

    public int getBuyersInMarket() {
        return buyersInMarket.get();
    }

    public void markBuyerEnter() {
        buyersInMarket.getAndIncrement();
    }

    public void markBuyerGoOut() {
        buyersComplete.getAndIncrement();
        buyersInMarket.getAndDecrement();
    }

    public boolean allBuyersComplete() {
        return buyersComplete.get() == PLAN;
    }

    public Basket getBasket() {
        try {
            return market.getBaskets().take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void returnBasket(Basket basket) {
        market.getBaskets().offer(basket);
        System.out.printf("Buyer return basket. We have %d free baskets.%n", market.getBaskets().size());
    }

    public Market getMarket() {
        return market;
    }
}
