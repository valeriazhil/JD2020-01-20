package by.it.zhuravaskarabahataya.jd01_08.oop;

public class Intern extends Surgeon{

    private String name;

    public String getName() {
        return name;
    }

    public Intern(String name) {
        this.name = name;
        System.out.println("Пришел интерн");
    }

    @Override
    void operate() {
        super.operate();
    }



    @Override
    public void treat() {
        operate();
    }


}
