package by.it.kondratev.jd02_02;

import java.util.List;

class Buyer extends Thread implements IBuyer, IuseBacket {

    Backet backet = new Backet();
    List<String> list = backet.list;

    Buyer (int number) { super( "Покупатель № " + number); }

    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println("Зашёл в магазин " + getName());
    }

    @Override
    public void takeBacket() {
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
        int good_number = Helper.random(0, Market.goods_list.size()-1);
        String good_name = Market.goods_list.get(good_number);
        list.add(good_name);
        System.out.println("Положил " + good_name + " в корзину " + getName());
    }

    @Override
    public void goOut() {
        System.out.println("Ушёл из магазина " + this.getName());
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
