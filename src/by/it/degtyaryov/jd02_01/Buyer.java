package by.it.degtyaryov.jd02_01;

class Buyer extends Thread implements IBuyer, IUseBasket {

    private Basket basket;
    private Good chosenGood;
    private final boolean isPensioner;
    private final double speedFactor;

    Buyer(int number, boolean isPensioner) {
        super("Buyer №" + number);
        this.basket = new Basket();
        this.isPensioner = isPensioner;
        this.speedFactor = (isPensioner) ? 1.5 : 1;
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        int goodsToBuy = Helper.getRandom(1, 4);
        for (int i = 0; i < goodsToBuy; i++) {
            chooseGoods();
            putGoodsToBasket();
        }
        System.out.printf("%s end choosing of %d goods and his basket contains: %s%n",
                this, goodsToBuy, basket.toString().toLowerCase());
        goOut();
    }

    @Override
    public void enterToMarket() {
        Dispatcher.buyerInMarket++;
        System.out.printf("%s enter to the market.%n", this);
    }

    @Override
    public void chooseGoods() {
        System.out.printf("%s is choosing goods.%n", this);
        Helper.sleep((int) (Helper.getRandom(500, 2000) * speedFactor));
        chosenGood = Helper.getRandomGood();
        System.out.printf("%s has chosen %s.%n", this, chosenGood.getName().toLowerCase());
    }

    @Override
    public void goOut() {
        Dispatcher.buyerInMarket--;
        System.out.printf("%s go out from the market.%n", this);
    }

    @Override
    public void takeBasket() {
        System.out.printf("%s is taking basket.%n", this);
        Helper.sleep((int) (Helper.getRandom(500, 2000) * speedFactor));
        System.out.printf("%s has taken basket.%n", this);
    }

    @Override
    public void putGoodsToBasket() {
        System.out.printf("%s start put good in basket.%n", this);
        Helper.sleep((int) (Helper.getRandom(500, 2000) * speedFactor));
        basket.add(chosenGood);
        System.out.printf("%s put in basket %s.%n", this, chosenGood.getName().toLowerCase());
        chosenGood = null;
    }

    @Override
    public String toString() {
        String age = (isPensioner) ? "Pensioner " : "";
        return age + this.getName();
    }
}
