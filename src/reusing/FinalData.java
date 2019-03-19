package reusing;//: reusing/FinalData.java
// The effect of final on fields.
import java.util.*;
import static net.mindview.util.Print.*;

class Value {
  int i; // Package access
  public Value(int i) { this.i = i; }
}

public class FinalData {
  private static Random rand = new Random(47);
  private String id;
  public FinalData(String id) { this.id = id; }
  // Can be compile-time constants:
  //编译时常量
  private final int valueOne = 9;//编译时常量
  private static final int VALUE_TWO = 99;//编译时常量，static+final命名惯例为大写+下划线。
  // Typical public constant:
  public static final int VALUE_THREE = 39;//通常static final用public访问修饰符更为典型。

  // Cannot be compile-time constants:
  //非编译时常量
  //以下两个差异只有在***运行时***给final赋值时，才会出现。因为编译时常量并不会区别对待final的static和non-static
  private final int i4 = rand.nextInt(20);//non-static每次实例化新对象都会赋值一次。
  static final int INT_5 = rand.nextInt(20);//static-类加载时，赋值一次，不会再变。

  private Value v1 = new Value(11);
  private final Value v2 = new Value(22);
  private static final Value VAL_3 = new Value(33);
  // Arrays:
  private final int[] a = { 1, 2, 3, 4, 5, 6 };
  public String toString() {
    return id + ": " + "i4 = " + i4 + ", INT_5 = " + INT_5;
  }
  public static void main(String[] args) {
    FinalData fd1 = new FinalData("fd1");
    //! fd1.valueOne++; // Error: can't change value
    fd1.v2.i++; // Object isn't constant!///v2是引用类型，其引用不可修改，但是对象的内容是可以修改的。
    fd1.v1 = new Value(9); // OK -- not final
    for(int i = 0; i < fd1.a.length; i++)///同上，数组是引用类型，其引用不可修改，但是对象的内容是可以修改的。
      fd1.a[i]++; // Object isn't constant!
    //! fd1.v2 = new Value(0); // Error: Can't
    //! fd1.VAL_3 = new Value(1); // change reference
    //! fd1.a = new int[3];
    print(fd1);
    print("Creating new FinalData");
    FinalData fd2 = new FinalData("fd2");
    print(fd1);
    print(fd2);
  }
} /* Output:
fd1: i4 = 15, INT_5 = 18
Creating new FinalData
fd1: i4 = 15, INT_5 = 18
fd2: i4 = 13, INT_5 = 18
*///:~
