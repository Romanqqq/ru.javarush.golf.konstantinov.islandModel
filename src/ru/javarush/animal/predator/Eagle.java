package ru.javarush.animal.predator;

import ru.javarush.animal.Predator;
import ru.javarush.animal.Raptor;
import ru.javarush.parameter.Info;

public class Eagle extends Predator implements Raptor {
    private static int maxQuantityLocation = Info.eagleMaxQuantityLocation;

    public Eagle() {
        super(3, 6, 1);
    }

    public static int getMaxQuantityLocation() {
        return maxQuantityLocation;
    }
}
