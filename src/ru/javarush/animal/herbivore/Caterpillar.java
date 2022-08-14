package ru.javarush.animal.herbivore;

import ru.javarush.animal.Herbivore;
import ru.javarush.animal.Herbivorous;
import ru.javarush.parameter.Info;

public class Caterpillar extends Herbivore implements Herbivorous {
    private static int maxQuantityLocation = Info.caterpillarMaxQuantityLocation;

    public Caterpillar() {
        super(0, 0.01, 0);
    }

    public static int getMaxQuantityLocation() {
        return maxQuantityLocation;
    }
}
