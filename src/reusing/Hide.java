package reusing;//: reusing/Hide.java
// Overloading a base-class method name in a derived
// class does not hide the base-class versions.

import static net.mindview.util.Print.*;

//If a Java base class has a method name that’s overloaded several times,
//        redefining that        method name in the derived class will not hide any of the base-class versions
class Homer {
    char doh(char c) {
        print("doh(char)");
        return 'd';
    }

    float doh(float f) {
        print("doh(float)");
        return 1.0f;
    }
}

class Milhouse {
}

class Bart extends Homer {
    void doh(Milhouse m) {
        print("doh(Milhouse)");
    }

    @Override
    char doh(char c) {
        print("我就呵呵了");

        return 'l';
    }
}

public class Hide {
    public static void main(String[] args) {
        Bart b = new Bart();
        b.doh(1);
        b.doh('x');
        b.doh(1.0f);
        b.doh(new Milhouse());
    }
} /* Output:
doh(float)
doh(char)
doh(float)
doh(Milhouse)
*///:~
