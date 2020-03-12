package by.it.kondratev.jd02_03;

import java.util.ArrayList;
import java.util.List;

class Basket {

    private final List<Good> goods = new ArrayList<>();

    public void add(Good item) {
        goods.add(item);
    }

    public void clear() {
        goods.clear();
    }

    public List<Good> getGoods() {
        return goods;
    }

    public double getSum() {
        double sum = 0;
        for (Good good : goods) {
            sum += good.getPrice();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder basket = new StringBuilder();
        for (Good item : goods) {
            basket.append(item);
            basket.append("; ");
        }
        return basket.toString();
    }
}
