package ru.javarush.animal.herbivore;

import ru.javarush.animal.Herbivore;

public class Horse extends Herbivore {
    private static int maxQuantityTypeAnimal = 20;

    public Horse() {
        super(4, 400, 60, 6);
    }

    public static int getMaxQuantityTypeAnimal() {
        return maxQuantityTypeAnimal;
    }
}
