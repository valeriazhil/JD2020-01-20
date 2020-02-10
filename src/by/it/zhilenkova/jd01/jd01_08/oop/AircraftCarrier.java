package by.it.zhilenkova.jd01.jd01_08.oop;

  class AircraftCarrier extends WarShip {
      private String caliber;
      private String s = "AircraftCarrier can swim";



      //динамический полтиорфизм (совпадают имена метода и параметры) - переопределение

      @Override
      public String swim (){
          return s;
      }

      //статический полиморфизм (меняются параметры метода) - перегрузка

      @Overload
      void shoot(int distance1, String caliber) {
          super.distance=distance1;
          this.caliber=caliber;
          System.out.println("I can shoot "+distance+" km, "+"caliber = "+caliber);
      }


      void havePlanes (){
          System.out.println("I have planes");
      }

      @Override
      public String toString() {
          return "this is class AircraftCarrier";
          //super.toString();
      }
  }
