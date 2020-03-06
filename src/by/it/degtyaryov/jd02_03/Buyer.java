package by.it.degtyaryov.jd02_03;

import java.util.concurrent.Semaphore;

class Buyer implements Runnable, IBuyer, IUseBasket {

    private static Semaphore semaphore = new Semaphore(20);

    private static int counter = 0;
    private final int id = counter++;

    private final boolean pensioner;
    private final double speedFactor;
    private final BuyerManager manager;

    private String name;
    private Good chosenGood;
    private boolean waiting;
    private Basket basket;

    public Buyer(boolean pensioner, BuyerManager manager) {
        this.name = "Buyer №" + id;
        this.pensioner = pensioner;
        this.speedFactor = (pensioner) ? 1.5 : 1;
        this.manager = manager;
        manager.markBuyerEnter();
    }

    public Basket getBasket() {
        return basket;
    }

    public boolean isPensioner() {
        return pensioner;
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        int countGoods = Helper.getRandom(1, 4);
        chooseAndTakeGoods(countGoods);
        goToQueue();
        goOut();
    }

    private void chooseAndTakeGoods(int countGoods) {
        try {
            semaphore.acquire();
            System.out.printf("%s start choosing of %d goods.", this, countGoods);
            for (int i = 0; i < countGoods; i++) {
                chooseGoods();
                putGoodsToBasket();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    @Override
    public void enterToMarket() {
        System.out.printf("%s enter to the market.%n", this);
    }

    @Override
    public void takeBasket() {
        System.out.printf("%s is taking basket.%n", this);
        Helper.sleep((int) (Helper.getRandom(500, 2000) * speedFactor));
        basket = manager.getBasket();
        System.out.printf("%s has taken basket.%n", this);
    }

    @Override
    public void chooseGoods() {
        System.out.printf("%s is choosing goods.%n", this);
        Helper.sleep((int) (Helper.getRandom(500, 2000) * speedFactor));
        chosenGood = Helper.getRandomGood();
        System.out.printf("%s has chosen %s.%n", this, chosenGood.getName().toLowerCase());
    }

    @Override
    public void putGoodsToBasket() {
        System.out.printf("%s start put %s in basket.%n", this, chosenGood.getName().toLowerCase());
        Helper.sleep((int) (Helper.getRandom(500, 2000) * speedFactor));
        basket.add(chosenGood);
        System.out.printf("%s put in basket %s.%n", this, chosenGood.getName().toLowerCase());
        chosenGood = null;
    }

    @Override
    public void goToQueue() {
        System.out.printf("%s stand in queue.%n", this);
        synchronized (this) {
            try {
                Queue.add(this);
                waiting = true;
                while (waiting) {
                    this.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void goOut() {
        basket.clear();
        manager.returnBasket(basket);
        manager.markBuyerGoOut();
        System.out.printf("%s go out from the market.%n", this);
    }

    @Override
    public String toString() {
        String age = (pensioner) ? "Pensioner " : "";
        return age + this.name;
    }

    public void endWaiting() {
        this.waiting = false;
    }
}
