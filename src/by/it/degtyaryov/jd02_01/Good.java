package by.it.degtyaryov.jd02_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Good {

    public static final List<Good> ALL_GOODS = new ArrayList<>(Arrays.asList(
            new Good("Milk", 2.1),
            new Good("Bread", 0.7),
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

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Good %s, price %.2f", name, price);
    }
}
