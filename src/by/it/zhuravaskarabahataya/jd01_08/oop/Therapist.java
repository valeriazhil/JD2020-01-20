package by.it.zhuravaskarabahataya.jd01_08.oop;

abstract class Therapist implements Doctor {

    private String name;

    public String getName() {
        return name;
    }

    public Therapist() {
        System.out.println("Новый терапевт пришел на работу.");
    }

    public void examineThePatient(){
        System.out.println("Терапевт проводит осмотр.");
    }



    @Override
    public void treat() {
        examineThePatient();
    }


}
