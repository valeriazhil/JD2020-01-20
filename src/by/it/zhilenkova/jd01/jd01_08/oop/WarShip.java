package by.it.zhilenkova.jd01.jd01_08.oop;

 abstract class WarShip implements Ship {
     int distance;

    void shoot (int distance){
        this.distance=distance;
        System.out.println("I can shoot - "+distance+" distance");
    }


     @Override
     public String toString() {
         return "This is class WarShip";
     }
 }
