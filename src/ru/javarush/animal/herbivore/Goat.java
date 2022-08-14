package ru.javarush.animal.herbivore;

import ru.javarush.animal.Herbivore;
import ru.javarush.animal.Herbivorous;
import ru.javarush.parameter.Info;

public class Goat extends Herbivore implements Herbivorous {
    private static int maxQuantityLocation = Info.goatMaxQuantityLocation;

    public Goat() {
        super(3, 60, 10);
    }

    public static int getMaxQuantityLocation() {
        return maxQuantityLocation;
    }


}



