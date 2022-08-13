package ru.javarush.animal.herbivore;

import ru.javarush.animal.Herbivore;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Mouse extends Herbivore {
    private static int maxQuantityTypeAnimal = 500;

    public Mouse() {
        super(1, 0.05, 0.01, 2);
    }

    public static int getMaxQuantityTypeAnimal() {
        return maxQuantityTypeAnimal;
    }

    @Override
    public void eat(List<?> plants, List<?> herbivores) {
        try {
            if (this.getSaturation() < this.getSaturationMax()) {
                int chanceEat = ThreadLocalRandom.current().nextInt(100);
                if (chanceEat > 50) {
                    double difference = this.getSaturationMax() - this.getSaturation();
                    if (plants.size() > difference) {
                        this.setSaturation(this.getSaturationMax());
                        this.setHungryAnimalTime(this.getHungryAnimalTimeMax());
                        plants.subList(0, (int) difference).clear();
                    } else if (chanceEat < 10) {
                        for (Object herbivore : herbivores) {
                            Herbivore herbivoreCaterpillar = (Herbivore) herbivore;
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
