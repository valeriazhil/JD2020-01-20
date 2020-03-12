package by.it.cherkas.jd02_03;

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

    public void clear() {
        goods = new ArrayList<>();
    }
}
