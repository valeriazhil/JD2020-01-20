package by.it.bunkov.jd01_08;

class Matrix extends Var {

    private double[][] value;


    Matrix(double[][] value) {

    this.value=value;
    }



    Matrix(Matrix matrix){
        this.value=matrix.value;
    }







    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder("{{");
        String delimiter="";
        for (double[] element : value){
            sb.append(delimiter).append(element);
            delimiter=", ";
        }
        sb.append("}}");
        return  sb.toString();

    }


}







