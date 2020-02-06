package by.it.zhuravaskarabahataya.jd01_08.oop;

public class Cardiologist extends Therapist {

    private String name;

    public String getName() {
        return name;
    }

    public Cardiologist() {
        System.out.println("Вот и кардиолог");
    }

    @Override
    public void examineThePatient() {
        System.out.println("Кардиолог слушает сердечные тоны");
    }



    @Override
    public void treat() {
        examineThePatient();
    }


}
