package by.it.zhilenkova.jd01.jd01_07;

 class Vector extends Var {
  private double[] value;


   Vector(double[] value) {
    this.value = value;
  }

   Vector(Vector vector) {
    this.value = vector.value;
  }

   Vector(String strVector) {
    strVector=strVector.replaceAll("[{|}]","");
    String[] mString = strVector.split(",");
    this.value = new double[mString.length];
    for (int i = 0; i <mString.length ; i++) {
     value[i] =Double.parseDouble(mString[i].trim());
    }
  }



  @Override
  public String toString() {
   StringBuilder sb = new StringBuilder("{");
   String delimeter = "";
   for (double element : value){
    sb.append(delimeter).append(element);
    delimeter = ", ";
   }
   sb.append("}");
   return sb.toString();
  }
 }

