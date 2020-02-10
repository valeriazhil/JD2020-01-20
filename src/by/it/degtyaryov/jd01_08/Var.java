package by.it.degtyaryov.jd01_08;

abstract class Var implements Operation {

    @Override
    public Var add(Var other) {
        System.out.println("Невозможно выполнить операцию " + this + " + " + other);
        return null;
    }
	
	public abstract Var add(Scalar scalar);
    public abstract Var add(Vector vector);
    public abstract Var add(Matrix matrix);

    @Override
    public Var sub(Var other) {
        System.out.println("Невозможно выполнить операцию " + this + " - " + other);
        return null;
    }
	
	public abstract Var sub(Scalar scalar);
    public abstract Var sub(Vector vector);
    public abstract Var sub(Matrix matrix);

    @Override
    public Var mul(Var other) {
        System.out.println("Невозможно выполнить операцию " + this + " * " + other);
        return null;
    }
	
	public abstract Var mul(Scalar scalar);
    public abstract Var mul(Vector vector);
    public abstract Var mul(Matrix matrix);

    @Override
    public Var div(Var other) {
        System.out.println("Невозможно выполнить операцию " + this + " / " + other);
        return null;
    }
	
	public abstract Var div(Scalar scalar);
    public abstract Var div(Vector vector);
    public abstract Var div(Matrix matrix);
}
