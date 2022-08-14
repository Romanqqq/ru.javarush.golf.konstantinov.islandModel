package ru.javarush.animal.herbivore;

import ru.javarush.animal.Herbivore;
import ru.javarush.animal.Herbivorous;
import ru.javarush.parameter.Info;

public class Buffalo extends Herbivore implements Herbivorous {
    private static int maxQuantityLocation = Info.buffaloMaxQuantityLocation;

    public Buffalo() {
        super(3, 700, 100);
    }

    public static int getMaxQuantityLocation() {
        return maxQuantityLocation;
    }


}
