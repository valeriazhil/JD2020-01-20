package by.it.degtyaryov.jd01_08.oop;

class Theater extends PublicBuilding {

    private int numsSeats;
	private double ticketPrice;

    Theater(int floors, String address, String name, int numsSeats, double ticketPrice) {
        super(floors, address, name);
        this.numsSeats = numsSeats;
        this.ticketPrice = ticketPrice;
    }

    @Override
    public void clean() {
        System.out.println("{Динамический полиморфизм} Театр убран.");
    }
	
    @Override
    public String toString() {
        return new StringBuilder()
                .append(super.toString())
                .append(". Количество мест в театре ")
                .append(numsSeats)
                .append(". Цена билета ")
                .append(ticketPrice)
                .toString();
    }
}
