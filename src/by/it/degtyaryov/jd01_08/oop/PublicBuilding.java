package by.it.degtyaryov.jd01_08.oop;

abstract class PublicBuilding implements Building {
    private int floors;

    private String address;
    private String name;

    PublicBuilding(int floors, String address, String name) {
        this.floors = floors;
        this.address = address;
        this.name = name;
    }

    @Override
    public void rent(int term) {
        System.out.printf("Здание %s сдано в аренду на %d дней.%n", name, term);
    }
	
	public void rent() {
        System.out.printf("Здание %s сдано в аренду на неопределенный срок.%n", name);
    }
	
	public void rent(String term) {
        System.out.printf("Здание %s сдано в аренду на %s.%n", name, term);
    }

    @Override
    public void tearDown() {
        System.out.printf("Здание %s разрушено.%n", name);
    }

    @Override
    public void clean() {
        System.out.printf("Здание %s убрано.%n", name);
    }

    @Override
    public void repair() {
        System.out.printf("Здание %s отремонтировано.%n", name);
    }

    @Override
    public void reconstruct() {
        System.out.printf("Здание %s реконструировано.%n", name);
    }

    @Override
    public void sell(int price) {
        System.out.printf("Здание %s продано за %d руб.%n", name, price);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Общественное здание ").append(name)
                .append(" по адресу ").append(address)
                .toString();
    }
}
