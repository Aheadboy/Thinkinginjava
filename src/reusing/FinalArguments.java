package reusing;//: reusing/FinalArguments.java
// Using "final" with method arguments.
//final参数，主要用于匿名内部类。
class Gizmo {
    public void spin() {
    }
}

public class FinalArguments {
    public static void main(String[] args) {
        FinalArguments bf = new FinalArguments();
        bf.without(null);
        bf.with(null);
    }

    void with(final Gizmo g) {
        //! g = new Gizmo(); // Illegal -- g is final
    }

    void without(Gizmo g) {
        g = new Gizmo(); // OK -- g not final
        g.spin();
    }

    // void f(final int i) { i++; } // Can't change
    // You can only read from a final primitive:
    int g(final int i) {//个人感觉基本类型final参数好像没什么用。
        return i + 1;
    }
} ///:~
