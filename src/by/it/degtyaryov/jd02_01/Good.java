package by.it.degtyaryov.jd02_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Good {

    public static final List<Good> ALL_GOODS = new ArrayList<>(Arrays.asList(
            new Good("Milk", 2.1),
            new Good("Bread", 0.7),
            new Good("Beer", 1.3),
            new Good("Sweets", 8.99),
            new Good("Eggs", 2.0),
            new Good("Water", 1.0)));

    private String name;
    private double price;

    public Good(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s (price %.2f)", name, price);
    }
}
