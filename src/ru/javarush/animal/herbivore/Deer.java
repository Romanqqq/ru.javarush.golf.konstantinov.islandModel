package ru.javarush.animal.herbivore;

import ru.javarush.animal.Herbivore;
import ru.javarush.animal.Herbivorous;
import ru.javarush.parameter.Info;

public class Deer extends Herbivore implements Herbivorous {
    private static int maxQuantityLocation = Info.deerMaxQuantityLocation;

    public Deer() {
        super(4, 300, 50, 4);
    }

    public static int getMaxQuantityLocation() {
        return maxQuantityLocation;
    }
}
