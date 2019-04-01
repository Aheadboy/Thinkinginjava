package reusing;//: reusing/Beetle.java
// The full process of initialization.
//加载类首先加载其父类，不管父类有没有被实例化。如果父类还有父类，以此类推
//加载的时候初始化static代码块，按其在源码中的顺序进行。
//实例化一个类，先实例化其父类，如果父类还有父类，以此类推。

import static net.mindview.util.Print.*;

class Insect {
    private static int x1 = printInit("static Insect.x1 initialized");//47
    protected int j;
    private int i = 9;

    Insect() {
        print("i = " + i + ", j = " + j);
        j = 39;
    }

    static int printInit(String s) {
        print(s);
        return 47;
    }
}

public class Beetle extends Insect {

    private static int x2 = printInit("static Beetle.x2 initialized");
    private int k = printInit("Beetle.k initialized");

    public Beetle() {
        print("k = " + k);
        print("j = " + j);
    }

    public static void main(String[] args) {///首先发现有加载类的必要
        print("Beetle constructor");
        Beetle b = new Beetle();//其次，发现有初始化的必要。//这里的new也有加载的必要，但是上面的static main方法已经进行了加载。就没有再加载，这里主要体现初始化的必要。
    }

} /* Output:
static Insect.x1 initialized
static Beetle.x2 initialized
Beetle constructor
i = 9, j = 0
Beetle.k initialized
k = 47
j = 39
*///:~
