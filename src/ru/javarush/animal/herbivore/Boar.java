package ru.javarush.animal.herbivore;

import ru.javarush.animal.Animal;
import ru.javarush.animal.Herbivore;
import ru.javarush.animal.Herbivorous;
import ru.javarush.parameter.Info;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class Boar extends Herbivore implements Herbivorous {
    private static int maxQuantityLocation = Info.boarMaxQuantityLocation;

    public Boar() {
        super(2, 400, 50, 8);
    }

    public static int getMaxQuantityLocation() {
        return maxQuantityLocation;
    }

    @Override
    public void eat(List<?> foodList, List<?> listFood) {
        try {
            if (this.getSaturation() < this.getSaturationMax()) {
                int chanceEat = ThreadLocalRandom.current().nextInt(0, 100);
                if (chanceEat > 50) {
                    double difference = this.getSaturationMax() - this.getSaturation();
                    if (foodList.size() > difference) {
                        this.setSaturation(this.getSaturationMax());
                        this.setHungryAnimalTime(this.getHungryAnimalTimeMax());
                        foodList.subList(0, (int) difference).clear();
                    }
                } else if (chanceEat > 10 && chanceEat < 50) {
                    for (Object herbivore : listFood) {
                        Animal herbivorous = (Animal) herbivore;
                        if (herbivorous.getClass().getSimpleName().equals("Mouse")) {
                            listFood.remove(herbivore);
                        }
                    }
                } else if (chanceEat < 10) {
                    for (Object herbivore : listFood) {
                        Animal herbivorous = (Animal) herbivore;
                        if (herbivorous.getClass().getSimpleName().equals("Caterpillar")) {
                            listFood.remove(herbivore);
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
