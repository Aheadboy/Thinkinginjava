package typeinfo;//: typeinfo/ClassInitialization.java

import java.util.*;
//
//笔记：
//获取Class object 的三种方式。
//        Class.forName()如果没有目标类的对象可以用这个方法。如果类还没有加载，会先加载。
//        objectInstance.getClass()通过目标类的对象来获取。
//        TargetClass.class通过-类字面常量-来获取。相比第一种，这种方式优势如下：
//          1、简单；
//          2、安全编译时检查，而非运行时，不需要try块。
//          3、懒初始化，也更高效。
//              1、懒初始化是发生在类加载的初始化中。
//              2、类加载分为三阶段：
//                  1、加载字节码到JVM
//                  2、link阶段。只分配内存，赋默认值。
//                  3、按照代码顺序进行初始化。懒初始化发生在这一步。有必要时才执行这一步。
class Initable {
    static final int staticFinal = 47;
    static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);

    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2 {
    static int staticNonFinal = 147;

    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3 {
    static int staticNonFinal = 74;

    static {
        System.out.println("Initializing Initable3");
    }
}

public class ClassInitialization {
    public static Random rand = new Random(47);

    public static void main(String[] args) throws Exception {
        Class initable = Initable.class;
        System.out.println("After creating Initable ref");
        // Does not trigger initialization:
        System.out.println(Initable.staticFinal);
        // Does trigger initialization:
        System.out.println(Initable.staticFinal2);
        // Does trigger initialization:
        System.out.println(Initable2.staticNonFinal);
        Class initable3 = Class.forName("Initable3");
        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.staticNonFinal);
    }
} /* Output:
After creating Initable ref
47
Initializing Initable
258
Initializing Initable2
147
Initializing Initable3
After creating Initable3 ref
74
*///:~
