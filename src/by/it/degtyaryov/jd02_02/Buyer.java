package by.it.degtyaryov.jd02_02;

class Buyer extends Thread implements IBuyer, IUseBasket {

    private final boolean PENSIONER;
    private final double SPEED_FACTOR;

    private Basket basket;
    private Good chosenGood;

    Buyer(int number, boolean pensioner) {
        super("Buyer №" + number);
        this.PENSIONER = pensioner;
        this.SPEED_FACTOR = (pensioner) ? 1.5 : 1;
        this.basket = new Basket();
        Dispatcher.newBuyerInMarket();
    }

    public Basket getBasket() {
        return basket;
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        int countGoods = Helper.getRandom(1, 4);
        for (int i = 0; i < countGoods; i++) {
            chooseGoods();
            putGoodsToBasket();
        }
        System.out.printf("%s end choosing of %d goods and his basket contains: %s%n",
                this, countGoods, basket.toString().toLowerCase());
        goToQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.printf("%s enter to the market.%n", this);
    }

    @Override
    public void chooseGoods() {
        System.out.printf("%s is choosing goods.%n", this);
        Helper.sleep((int) (Helper.getRandom(500, 2000) * SPEED_FACTOR));
        chosenGood = Helper.getRandomGood();
        System.out.printf("%s has chosen %s.%n", this, chosenGood.getName().toLowerCase());
    }

    @Override
    public void goToQueue() {
        System.out.printf("%s stand in queue.%n", this);
        synchronized (this) {
            Queue.add(this);
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void goOut() {
        Dispatcher.buyerLeaveMarket();
        System.out.printf("%s go out from the market.%n", this);
    }

    @Override
    public void takeBasket() {
        System.out.printf("%s is taking basket.%n", this);
        Helper.sleep((int) (Helper.getRandom(500, 2000) * SPEED_FACTOR));
        System.out.printf("%s has taken basket.%n", this);
    }

    @Override
    public void putGoodsToBasket() {
        System.out.printf("%s start put %s in basket.%n", this, chosenGood.getName().toLowerCase());
        Helper.sleep((int) (Helper.getRandom(500, 2000) * SPEED_FACTOR));
        basket.add(chosenGood);
        System.out.printf("%s put in basket %s.%n", this, chosenGood.getName().toLowerCase());
        chosenGood = null;
    }

    @Override
    public String toString() {
        String age = (PENSIONER) ? "Pensioner " : "";
        return age + this.getName();
    }
}
