package ru.javarush.animal.herbivore;

import ru.javarush.animal.Herbivore;

public class Deer extends Herbivore {
    private static int maxQuantityTypeAnimal = 20;

    public Deer() {
        super(4, 300, 50, 4);
    }

    public static int getMaxQuantityTypeAnimal() {
        return maxQuantityTypeAnimal;
    }
}
