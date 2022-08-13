package ru.javarush.animal.herbivore;

import ru.javarush.animal.Herbivore;
public class Caterpillar extends Herbivore {
    private static int maxQuantityTypeAnimal = 1000;

    public Caterpillar() {
        super(0, 0.01, 0, 1);
    }

    public static int getMaxQuantityTypeAnimal() {
        return maxQuantityTypeAnimal;
    }
}
