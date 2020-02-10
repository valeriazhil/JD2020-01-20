package by.it.zhuravaskarabahataya.jd01_08.oop;

class PlasticSurgeon extends Surgeon{

    private String name;

    public String getName() {
        return name;
    }

    public PlasticSurgeon() {
        System.out.println("А вот и пластический хирург!");
    }

    @Override
    void operate() {
        System.out.println("Выполняю маммопластику.");
    }



    @Override
    public void treat() {
        operate();
    }


}
