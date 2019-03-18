package reusing;

public class Exercise5 {
    public static void main(String[] args) {
        new C();
    }
}

class A {
    public A() {
        System.out.println("I'm A");
    }
}

class B {
    public B() {
        System.out.println("I'm B");
    }
}

class C extends A {
    B b = new B();
}

//I'm A
//I'm B
