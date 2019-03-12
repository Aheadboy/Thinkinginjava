////ljj1 无法通过编译，作者本意
//package initialization;//: initialization/OverloadingVarargs2.java
//// {CompileTimeError} (Won't compile)
//
//public class OverloadingVarargs2 {
//  static void f(float i, Character... args) {
//    System.out.println("first");
//  }
//  static void f(Character... args) {
//    System.out.print("second");
//  }
//  public static void main(String[] args) {
//    f(1, 'a');
//    f('a', 'b');
//  }
//} ///:~
