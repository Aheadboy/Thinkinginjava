package reusing;//: reusing/Jurassic.java
// Making an entire class final.
//处于某些原因，类不能被继承。
//final类 由于不能被继承，那么，可以认为，这个类的所有方法都是final的效果。因为根本没法取重写基类的方法
class SmallBrain {}

final class Dinosaur {
  int i = 7;
  int j = 1;
  SmallBrain x = new SmallBrain();
  void f() {}
}

//! class Further extends Dinosaur {}
// error: Cannot extend final class 'Dinosaur'

public class Jurassic {
  public static void main(String[] args) {
    Dinosaur n = new Dinosaur();
    n.f();
    n.i = 40;
    n.j++;
  }
} ///:~
