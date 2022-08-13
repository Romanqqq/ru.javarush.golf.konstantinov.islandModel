package ru.javarush.animal.predator;

import ru.javarush.animal.Predator;

public class Eagle extends Predator {
    private static int maxQuantityTypeAnimal = 20;

    public Eagle() {
        super(3, 6, 1, 5);
    }

    public static int getMaxQuantityTypeAnimal() {
        return maxQuantityTypeAnimal;
    }
}
