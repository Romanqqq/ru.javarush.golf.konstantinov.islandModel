package ru.javarush.animal.predator;

import ru.javarush.animal.Predator;
import ru.javarush.animal.Raptor;
import ru.javarush.parameter.Info;

public class Fox extends Predator implements Raptor {
    private static int maxQuantityLocation = Info.foxMaxQuantityLocation;

    public Fox() {
        super(2, 8, 2);
    }

    public static int getMaxQuantityLocation() {
        return maxQuantityLocation;
    }

}
