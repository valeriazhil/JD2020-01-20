package by.it.kondratev.jd02_03;

class Good {

    private double price;
    private String name;

    public Good(String name, double price) {
        this.price = price;
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s (price %.2f)", name, price);
    }
}
