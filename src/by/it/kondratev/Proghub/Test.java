package by.it.kondratev.Proghub;

interface AA {
    int a();
}

class A implements AA {
    public int a() {
        return 1;
    }
}

class B implements AA {
    public int a() {
        return 1;
    }
}

class D {
    B b = new B();
    A a = new A();

    public int sum() {
        return a.a()+b.a();
    }

}