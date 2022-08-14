package ru.javarush.animal.predator;

import ru.javarush.animal.Predator;
import ru.javarush.animal.Raptor;
import ru.javarush.parameter.Info;

public class Bear extends Predator implements Raptor {
    private static int maxQuantityLocation = Info.bearMaxQuantityLocation;

    public Bear() {
        super(2, 500, 80);
    }

    public static int getMaxQuantityLocation() {
        return maxQuantityLocation;
    }
}
