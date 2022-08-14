package ru.javarush.animal.herbivore;

import ru.javarush.animal.Herbivore;
import ru.javarush.animal.Herbivorous;
import ru.javarush.parameter.Info;

public class Sheep extends Herbivore implements Herbivorous {
    private static int maxQuantityLocation = Info.sheepMaxQuantityLocation;

    public Sheep() {
        super(3, 70, 15);
    }

    public static int getMaxQuantityLocation() {
        return maxQuantityLocation;
    }
}
