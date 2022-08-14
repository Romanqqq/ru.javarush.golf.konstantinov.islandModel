package ru.javarush.animal.predator;

import ru.javarush.animal.Predator;
import ru.javarush.animal.Raptor;
import ru.javarush.parameter.Info;

public class Boa extends Predator implements Raptor {
    private static int maxQuantityLocation = Info.boaMaxQuantityLocation;

    public Boa() {
        super(1, 15, 3);
    }

    public static int getMaxQuantityLocation() {
        return maxQuantityLocation;
    }
}
