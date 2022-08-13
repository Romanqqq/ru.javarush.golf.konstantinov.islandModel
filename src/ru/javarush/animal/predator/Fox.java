package ru.javarush.animal.predator;

import ru.javarush.animal.Predator;

public class Fox extends Predator {
    private static int maxQuantityTypeAnimal = 30;

    public Fox() {
        super(2, 8, 2, 6);
    }

    public static int getMaxQuantityTypeAnimal() {
        return maxQuantityTypeAnimal;
    }

}
