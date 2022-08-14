package ru.javarush.animal.predator;


import ru.javarush.animal.Predator;
import ru.javarush.animal.Raptor;
import ru.javarush.parameter.Info;

public class Wolf extends Predator implements Raptor {
    private static int maxQuantityLocation = Info.wolfMaxQuantityLocation;

    public Wolf() {
        super(3, 50, 8, 8);
    }

    public static int getMaxQuantityLocation() {
        return maxQuantityLocation;
    }

}






