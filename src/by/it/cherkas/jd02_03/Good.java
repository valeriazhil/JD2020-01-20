package by.it.cherkas.jd02_03;

class Good {

    private String name;

    public Good(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return Helper.getPriceList().get(this);
    }

    @Override
    public String toString() {
        return name;
    }
}
