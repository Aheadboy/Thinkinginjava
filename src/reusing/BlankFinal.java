package reusing;//: reusing/BlankFinal.java
// "Blank" final fields.

class Poppet {
  private int i;
  Poppet(int ii) { i = ii; }
}

public class BlankFinal {
  private final int i = 0; // Initialized final
  private final int j; // Blank final、、没有在申明时赋值 的final称为final；即使这里不复制，构造函数那边也必须赋值，初始化。
  private final Poppet p; // Blank final reference
  // Blank finals MUST be initialized in the constructor://构造函数这边必须初始化，blank field .
  public BlankFinal() {
    j = 1; // Initialize blank final
    p = new Poppet(1); // Initialize blank final reference
  }
  public BlankFinal(int x) {
    j = x; // Initialize blank final
    p = new Poppet(x); // Initialize blank final reference
  }
  public static void main(String[] args) {
    new BlankFinal();
    new BlankFinal(47);
  }
} ///:~
