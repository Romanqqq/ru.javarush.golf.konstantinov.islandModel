package ru.javarush.animal.herbivore;

import ru.javarush.animal.Herbivore;
public class Buffalo extends Herbivore {
    private static int maxQuantityTypeAnimal = 10;

    public Buffalo() {
        super(3, 700, 100, 4);
    }

    public static int getMaxQuantityTypeAnimal() {
        return maxQuantityTypeAnimal;
    }


}
