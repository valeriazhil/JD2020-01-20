package by.it.kondratev.jd02_01;

class Buyer extends Thread implements IBuyer, IuseBacket {

    private Basket basket;

    Buyer (int number) {
        super( "Покупатель № " + number);
        this.basket = new Basket("Покупатель № " + number);
    }

    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println("Зашёл в магазин " + getName());
    }

    @Override
    public void takeBasket() {
        System.out.println("Взял корзину " + getName());
    }

    @Override
    public void chooseGoods()  {
        System.out.println("Начал выбирать товары " + getName());
        int goods_count = Helper.random(1,4);
        for (int i = 0; i < goods_count; i++) {
            putGoodsToBacket();
        }
        System.out.println("Окончил выбирать товары " + getName());

    }

    @Override
    public void putGoodsToBacket() {
        int good_number = Helper.random(0,WorkDay.GOODS_LIST.size()-1);
        String good_name = WorkDay.GOODS_LIST.get(good_number);
        basket.list.add(good_name);
        System.out.println("Положил " + good_name + " в корзину " + getName());
    }

    @Override
    public void goOut() {
        System.out.println("Ушёл из магазина " + this.getName() + " " + basket);
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
