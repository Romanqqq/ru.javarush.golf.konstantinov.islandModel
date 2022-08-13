package ru.javarush.animal.predator;

import ru.javarush.animal.Predator;

public class Bear extends Predator {
    private static int maxQuantityTypeAnimal = 5;

    public Bear() {
        super(2, 500, 80, 20);
    }

    public static int getMaxQuantityTypeAnimal() {
        return maxQuantityTypeAnimal;
    }
}
