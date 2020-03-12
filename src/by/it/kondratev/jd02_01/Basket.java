package by.it.kondratev.jd02_01;

import java.util.ArrayList;
import java.util.List;

class Basket {

    List<String> list;
    String basketsName;

    Basket (String byersName) {
        list = new ArrayList<String>();
        this.basketsName = "Корзина " + byersName;
    }

    @Override
    public String toString() {
        return basketsName + list;
    }
}
