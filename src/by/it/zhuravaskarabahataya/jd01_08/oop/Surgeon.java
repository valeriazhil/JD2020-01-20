package by.it.zhuravaskarabahataya.jd01_08.oop;

public abstract class Surgeon implements Doctor{
    int salarySurgeon = 5;
    private String name;

    public String getName() {
        return name;
    }

    public Surgeon(){
        System.out.println("А вот и новый хирург");
    }
    public Surgeon(String name){
        System.out.println("А вот и новый хирург"+ name);
        this.name = name;
    }

    void operate(){
        System.out.println("Я оперирую.");
        salarySurgeon++;
    }

    void operate(Surgeon assistant){
        System.out.println("Оперирую с помощником " + assistant.getName());
    }


    @Override
    public void treat() {
        operate();
    }


}
