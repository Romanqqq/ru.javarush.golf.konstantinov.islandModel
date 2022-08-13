package ru.javarush.animal.herbivore;

import ru.javarush.animal.Herbivore;

public class Rabbit extends Herbivore {

    private static int maxQuantityTypeAnimal = 150;

    public Rabbit() {
        super(2, 2, 0.45, 5);
    }

    public static int getMaxQuantityTypeAnimal() {
        return maxQuantityTypeAnimal;
    }
}
