package ru.javarush.animal.herbivore;

import ru.javarush.animal.Herbivore;

public class Sheep extends Herbivore {
    private static int maxQuantityTypeAnimal = 140;

    public Sheep() {
        super(3, 70, 15, 4);
    }

    public static int getMaxQuantityTypeAnimal() {
        return maxQuantityTypeAnimal;
    }
}
