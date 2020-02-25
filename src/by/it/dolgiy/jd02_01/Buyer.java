package by.it.dolgiy.jd02_01;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Buyer extends Thread implements IBuyer, IUseBasket{

    Buyer(int number){
        super("Buyer № " + number);
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+" enter to the Market");
    }

    @Override
    public void takeBasket() {
        System.out.println(this+" took a basket");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this+" started choosing goods");
        int timeout = Helper.random(500,2000);
        Helper.sleep(timeout);
        System.out.println(this+" finished choosing goods");
    }

    @Override
    public void putGoodsToBasket() {
        Set<Map.Entry<String, Integer>> goods = Helper.shoppingList().entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = goods.iterator();
        int countProducts = Helper.random(1,4);
        for (int i = 0; i < countProducts; i++) {
            int timeout = Helper.random(500,2000);
            Helper.sleep(timeout);
            Map.Entry<String, Integer> next = iterator.next();
            System.out.println(this+" shopping list:: "+next.getKey()+":"+next.getValue()+" ");
        }

    }

    @Override
    public void goOut() {
        System.out.println(this+" leave the Market");
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
