//ljj1 无法通过编译，作者的本意
////: generics/HijackedInterface.java
//// {CompileTimeError} (Won't compile)
//
//class Cat extends ComparablePet implements Comparable<Cat>{
//  // Error: Comparable cannot be inherited with
//  // different arguments: <Cat> and <Pet>
//  public int compareTo(Cat arg) { return 0; }
//} ///:~
