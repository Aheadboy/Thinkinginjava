package typeinfo;

//: typeinfo/ClassCasts.java

class Building {
}

class House extends Building {
}

public class ClassCasts {
    public static void main(String[] args) {
        Building b = new House();
        Class<House> houseType = House.class;
        House h = houseType.cast(b);//java5在Class object中新增的转型方法。
        h = (House) b; // ... or just do this.
    }
} ///:~
