package ru.javarush.parameter;

import java.util.HashMap;
import java.util.Map;

public class MapChance {
    public static Map<String, Integer> wolfEat = new HashMap<>();
    public static Map<String, Integer> bearEat = new HashMap<>();
    public static Map<String, Integer> foxEat = new HashMap<>();
    public static Map<String, Integer> eagleEat = new HashMap<>();
    public static Map<String, Integer> boaEat = new HashMap<>();

    static {
        wolfEat.put("Horse", 10);
        wolfEat.put("Deer", 15);
        wolfEat.put("Rabbit", 60);
        wolfEat.put("Mouse", 80);
        wolfEat.put("Goat", 60);
        wolfEat.put("Sheep", 70);
        wolfEat.put("Boar", 15);
        wolfEat.put("Buffalo", 10);
        wolfEat.put("Duck", 40);

        bearEat.put("Horse", 40);
        bearEat.put("Boa", 80);
        bearEat.put("Deer", 80);
        bearEat.put("Rabbit", 80);
        bearEat.put("Mouse", 90);
        bearEat.put("Goat", 70);
        bearEat.put("Sheep", 70);
        bearEat.put("Boar", 50);
        bearEat.put("Buffalo", 20);
        bearEat.put("Duck", 10);

        foxEat.put("Rabbit", 70);
        foxEat.put("Mouse", 90);
        foxEat.put("Duck", 60);
        foxEat.put("Caterpillar", 40);

        eagleEat.put("Fox", 10);
        eagleEat.put("Rabbit", 90);
        eagleEat.put("Mouse", 90);
        eagleEat.put("Duck", 90);

        boaEat.put("Fox", 15);
        boaEat.put("Rabbit", 20);
        boaEat.put("Mouse", 40);
        boaEat.put("Duck", 10);
    }
    public MapChance(){}
}
