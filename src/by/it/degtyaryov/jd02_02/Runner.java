package by.it.degtyaryov.jd02_02;

class Runner {

    public static void main(String[] args) {
        Market market = new Market();
        System.out.println("Market is opened.");
        market.start();
        market.end();
        System.out.println("Marked is closed.");
    }
}
