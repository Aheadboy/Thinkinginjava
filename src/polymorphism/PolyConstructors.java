package polymorphism;//: polymorphism/PolyConstructors.java
// Constructors and polymorphism
// don't produce what you might expect.
import static net.mindview.util.Print.*;

class Glyph {
  void draw() { print("Glyph.draw()"); }
  Glyph() {
    print("Glyph() before draw()");
    draw();
    print("Glyph() after draw()");
  }
}	

class RoundGlyph extends Glyph {
  private int radius = 1;
  RoundGlyph(int r) {
    radius = r;
    print("RoundGlyph.RoundGlyph(), radius = " + radius);
  }
  void draw() {
    print("RoundGlyph.draw(), radius = " + radius);
  }
}

public class PolyConstructors {
  public static void main(String[] args) {
    new RoundGlyph(5);
  }
} /* Output:
Glyph() before draw()
RoundGlyph.draw(), radius = 0
Glyph() after draw()
RoundGlyph.RoundGlyph(), radius = 5
*///:~
//编写构造函数的准则：用尽可能简单的方法使对象进入正常状态。如果可以的话避免调用其他方法。
//类的初始化过程：
//        1、在任何事物发生前，将分配给对象的存储空间初始化为零
//        2、调用父类构造器，父类初始化完毕，向下初始化子类。
//        3、子类按声明的顺序初始化成员
//        4、调用子类的构造函数。
//        （在类的内部。先初始化成员，最后调用构造函数）