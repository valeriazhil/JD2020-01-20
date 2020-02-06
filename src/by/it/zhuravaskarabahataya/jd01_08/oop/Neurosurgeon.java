package by.it.zhuravaskarabahataya.jd01_08.oop;

public class Neurosurgeon extends Surgeon{

    private String name;

    public String getName() {
        return name;
    }

    public Neurosurgeon(){
        System.out.println("А вот и нейрохирург!");
        int salarySurgeon = 10;
    }

    public Neurosurgeon(String name) {

        System.out.println("А вот и нейрохирург!");
        int salarySurgeon = 10;
        System.out.println(salarySurgeon);
    }

    @Override
     void operate() {
        System.out.println("Оперирую головной мозг.");
        salarySurgeon++;

    }



    @Override
    public void treat() {
        operate();
    }


}
