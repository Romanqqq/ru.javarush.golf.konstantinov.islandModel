package ru.javarush.plant;

import ru.javarush.parameter.Info;

public class Plant {
private int weight;
private static  int maxQuantityLocation = Info.plantMaxQuantityLocation;
    public  Plant() {
      this.weight=1;
    }
    public static int getMaxQuantityLocation() {
        return maxQuantityLocation;
    }
}
