package generics;
//ljj1注释，是程序能够运行，这里提示包中有同名类冲突。
//: generics/MultipleInterfaceVariants.java
// {CompileTimeError} (Won't compile)
//
//interface Payable<T> {}
//
//class Employee implements Payable<Employee> {}
//class Hourly extends Employee
//  implements Payable<Hourly> {} ///:~

