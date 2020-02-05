package by.it.bunkov.jd01_08;

class Vector  extends Var {

  private double[] value;

  Vector(double[ ] value) {
   this.value=value;
  }



 Vector (Vector vector) {
   this.value=vector.value;
}

    Vector(String str) {
  //  this.value=Double.parseDouble( str[" { { 1.0, 2.0 },  { 3.0, 4.0 } }\n"]);


    }

 @Override
 public String toString() {
  StringBuilder sb=new StringBuilder("{");
  String delimiter="";
  for (double element : value){
   sb.append(delimiter).append(element);
   delimiter=", ";
  }
  sb.append("}");
  return  sb.toString();

 }
}
