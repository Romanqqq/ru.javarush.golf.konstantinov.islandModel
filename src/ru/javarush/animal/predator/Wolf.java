package ru.javarush.animal.predator;


import ru.javarush.animal.Predator;

public class Wolf extends Predator {
    private static int maxQuantityTypeAnimal = 30;

    public Wolf() {
        super(3, 50, 8, 8);
    }

    public static int getMaxQuantityTypeAnimal() {
        return maxQuantityTypeAnimal;
    }

}






