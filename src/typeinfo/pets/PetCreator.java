//: typeinfo/pets/PetCreator.java
// Creates random sequences of Pets.
package typeinfo.pets;

import java.util.*;

public abstract class PetCreator {
    private Random rand = new Random(47);

    // The List of the different types of Pet to create:
    //这个list包含了，不同的Pet类型也就是不同的Class<? extents Pet>
    public abstract List<Class<? extends Pet>> types();

    /**
     * 通过Class object实例化Pet对象。
     *
     * @return
     */
    public Pet randomPet() { // Create one random Pet
        int n = rand.nextInt(types().size());
        try {
            return types().get(n).newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 调用randomPet创建一个含有随机Pet实例的数组。
     *
     * @param size
     * @return 包含Pet实例的数组
     */
    public Pet[] createArray(int size) {
        Pet[] result = new Pet[size];
        for (int i = 0; i < size; i++)
            result[i] = randomPet();
        return result;
    }

    public ArrayList<Pet> arrayList(int size) {
        ArrayList<Pet> result = new ArrayList<Pet>();
        Collections.addAll(result, createArray(size));
        return result;
    }
} ///:~
