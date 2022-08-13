package ru.javarush.plant;

public class Plant {
private int weight;
private static  int maxQuantity= 200;
    public  Plant() {
      this.weight=1;
    }
    public static int getMaxQuantity() {
        return maxQuantity;
    }
}
