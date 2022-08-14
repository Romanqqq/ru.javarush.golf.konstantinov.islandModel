package ru.javarush.animal.herbivore;

import ru.javarush.animal.Herbivore;
import ru.javarush.animal.Herbivorous;
import ru.javarush.parameter.Info;

public class Rabbit extends Herbivore implements Herbivorous {

    private static int maxQuantityLocation = Info.rabbitMaxQuantityLocation;

    public Rabbit() {
        super(2, 2, 0.45, 5);
    }

    public static int getMaxQuantityLocation() {
        return maxQuantityLocation;
    }
}
