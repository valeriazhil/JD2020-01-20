package by.it.zhilenkova.jd01.jd01_08;

import java.util.Arrays;

class Vector extends Var {
 private double[] value;

 public double[] getValue() {
  return value;
 }

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



 @Override
 public Var add(Var other) {
  Var var;
  if (other instanceof Scalar) {
   double[] result = Arrays.copyOf(value, value.length);
   for (int i = 0; i < result.length; i++) {
    result[i] += ((Scalar) other).getValue();
   }
   var = new Vector(result);
  }
  else if (other instanceof Vector) {
   double[] result = Arrays.copyOf(value, value.length);
   for (int i = 0; i < result.length; i++) {
    result[i] += ((Vector) other).value[i];
   }
   var = new Vector(result);
  } else {
   var = super.add(other);
  }
  return var;
 }

 @Override
 public Var sub(Var other) {
  Var var;
  if (other instanceof Scalar) {
   double scalar = ((Scalar) other).getValue();
   double[] result = Arrays.copyOf(this.value, this.value.length);
   for (int i = 0; i < result.length; i++) {
    result[i] -= scalar;
   }
   var = new Vector(result);
  } else if (other instanceof Vector) {
   double[] result = Arrays.copyOf(this.value, this.value.length);
   for (int i = 0; i < result.length; i++) {
    result[i] -= ((Vector) other).value[i];
   }
   var = new Vector(result);
  } else {
   var = super.sub(other);
  }
  return var;
 }

 @Override
 public Var div(Var other) {
  Var var;
  if (other instanceof Scalar) {
   double scalar = ((Scalar) other).getValue();
   double[] result = Arrays.copyOf(this.value, this.value.length);
   for (int i = 0; i < result.length; i++) {
    result[i] /= scalar;
   }
   var = new Vector(result);
  } else {
   var = super.div(other);
  }
  return var;
 }


 public Var mul(Var other) {
  Var var;
  if (other instanceof Scalar) {
   double scalar = ((Scalar) other).getValue();
   double[] result = Arrays.copyOf(this.value, this.value.length);
   for (int i = 0; i < result.length; i++) {
    result[i] *= scalar;
   }
   var = new Vector(result);
  } else if (other instanceof Vector) {
   double summa = 0.0;
   double[] result = Arrays.copyOf(this.value, this.value.length);
   for (int i = 0; i < result.length; i++) {
    result[i] *= ((Vector) other).value[i];
    summa += result[i];
   }
   var = new Scalar(summa);
  } else {
   var = super.mul(other);
  }
  return var;
 }





}

