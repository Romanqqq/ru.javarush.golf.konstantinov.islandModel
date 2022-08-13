package ru.javarush.animal.herbivore;

import ru.javarush.animal.Herbivore;

public class Goat extends Herbivore {
    private static int maxQuantityTypeAnimal = 140;

    public Goat() {
        super(3, 60, 10, 5);
    }

    public static int getMaxQuantityTypeAnimal() {
        return maxQuantityTypeAnimal;
    }


}



