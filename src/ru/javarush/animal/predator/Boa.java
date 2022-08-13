package ru.javarush.animal.predator;

import ru.javarush.animal.Predator;

public class Boa extends Predator {
    private static int maxQuantityTypeAnimal = 30;

    public Boa() {
        super(1, 15, 3, 10);
    }

    public static int getMaxQuantityTypeAnimal() {
        return maxQuantityTypeAnimal;
    }
}
