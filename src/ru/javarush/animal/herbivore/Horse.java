package ru.javarush.animal.herbivore;

import ru.javarush.animal.Herbivore;
import ru.javarush.animal.Herbivorous;
import ru.javarush.parameter.Info;

public class Horse extends Herbivore implements Herbivorous {
    private static int maxQuantityLocation = Info.horseMaxQuantityLocation;

    public Horse() {
        super(4, 400, 60, 6);
    }

    public static int getMaxQuantityLocation() {
        return maxQuantityLocation;
    }
}
