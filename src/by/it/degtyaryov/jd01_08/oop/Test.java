package by.it.degtyaryov.jd01_08.oop;

class Test {

    public static void main(String[] args) {
        PublicBuilding theater = new Theater(2, "Minsk", "Оперы и балета", 100, 10);
        PublicBuilding cafe = new Cafe(1, "Minsk", "Мята лаунч", 20, new String[]{"Суп", "Картошка"});
		
		System.out.println("---> toString():");
        System.out.println(theater);
        System.out.println(cafe);
		
		System.out.println("---> Статический полиморфизм:");
		theater.rent(5);
		cafe.rent();
		cafe.rent("7 дней");
		
		System.out.println("---> Динамический полиморфизм:");
        theater.clean();
        cafe.clean();
		
		System.out.println("---> Остальные методы интерфейса, с реализацией в базовом классе:");
		cafe.repair();
		cafe.reconstruct();
		cafe.sell(10000);
		cafe.tearDown();
    }
}