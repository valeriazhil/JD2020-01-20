package by.it.kondratev.jd02_02;

import java.util.ArrayList;
import java.util.List;

class Basket {

    List<String> list;
    String basketsName;

    Basket (String byersName) {
        list = new ArrayList<>();
        this.basketsName = "Корзина " + byersName;
    }

    @Override
    public String toString() {
        return basketsName + list;
    }
}
