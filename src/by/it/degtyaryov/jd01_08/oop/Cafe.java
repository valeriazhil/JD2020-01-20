package by.it.degtyaryov.jd01_08.oop;

import java.util.Arrays;

class Cafe extends PublicBuilding {

    private int countTables;
    private String[] menu;

    Cafe(int floors, String address, String name, int countTables, String[] menu) {
        super(floors, address, name);
        this.countTables = countTables;
        this.menu = Arrays.copyOf(menu, menu.length);
    }

    @Override
    public void clean() {
        System.out.println("{Динамический полиморфизм} Кафе убрано.");
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(super.toString())
                .append(". Количество столиков в кафе ")
                .append(countTables)
                .append(". Меню кафе: ")
                .append(Arrays.toString(menu))
                .toString();
    }
}
