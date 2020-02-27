package by.it.degtyaryov.jd02_01;

import java.util.ArrayList;
import java.util.List;

class Basket {
    private List<Good> goods = new ArrayList<>();

    public void put(Good item) {
        goods.add(item);
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
