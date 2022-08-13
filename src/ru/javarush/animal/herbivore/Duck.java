package ru.javarush.animal.herbivore;

import ru.javarush.animal.Animal;
import ru.javarush.animal.Herbivore;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Duck extends Herbivore {
    private static int maxQuantityTypeAnimal = 200;
    public Duck() {
        super(4, 1, 0.15, 4);
    }

    public static int getMaxQuantityTypeAnimal() {
        return maxQuantityTypeAnimal;
    }

    @Override
    public void eat(List<?> plants, List<?> herbivores) {
        try {
            if (this.getSaturation() < this.getSaturationMax()) {
                int chanceEat = ThreadLocalRandom.current().nextInt(100);
                if (chanceEat > 10) {
                    double difference = this.getSaturationMax() - this.getSaturation();
                    if (plants.size() > difference) {
                        this.setSaturation(this.getSaturationMax());
                        this.setHungryAnimalTime(this.getHungryAnimalTimeMax());
                        plants.subList(0, (int) difference).clear();
                    } else {
                        for (Object herbivore : herbivores) {
                            Animal herbivoreCaterpillar = (Animal) herbivore;
                            if (herbivoreCaterpillar.getClass().getSimpleName().equals("Caterpillar")) {
                                herbivores.remove(herbivore);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
