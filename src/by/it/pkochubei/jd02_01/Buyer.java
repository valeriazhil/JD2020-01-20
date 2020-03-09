package by.it.pkochubei.jd02_01;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Buyer extends Thread implements IBuyer, IUseBasket{

    Buyer(int number,String buyer){
        super("Buyer № " + number + buyer);
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
        if (Runner.pensioner){
            timeout = (int) (timeout*1.5);
        }
        Helper.sleep(timeout);
        System.out.println(this+" finished choosing goods");
    }

    @Override
    public void putGoodsToBasket() {
        Set<Map.Entry<String, Integer>> basket = Helper.shoppingList().entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = basket.iterator();
        StringBuffer shopL = new StringBuffer(this+" basket :: ");
        int countProducts = Helper.random(1,4);
        for (int i = 0; i < countProducts; i++) {
            int timeout = Helper.random(500,2000);
            if (Runner.pensioner){
                timeout = (int) (timeout*1.5);
            }
            Helper.sleep(timeout);
            int choice = Helper.random(1);
            for (int ch = 0; ch < choice; ch++) {
                iterator.next();
            }
            Map.Entry<String, Integer> next = iterator.next();
            shopL.append(next.getKey()).append(':').append(next.getValue()).append(';');
        }
        System.out.println(shopL);
    }

    @Override
    public void goOut() {
        System.out.println(this+" leave the Market");
        Runner.countOut++;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
