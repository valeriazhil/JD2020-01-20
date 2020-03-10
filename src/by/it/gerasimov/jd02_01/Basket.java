package by.it.gerasimov.jd02_01;

import java.util.ArrayList;
import java.util.List;

class Basket {

    private List<Good> goods = new ArrayList<>();

    public void addGood(Good good) {
        goods.add(good);
    }

    public List<Good> getGoods() {
        return goods;
    }
}
