package ru.javarush.animal.herbivore;

import ru.javarush.animal.Animal;
import ru.javarush.animal.Herbivore;
import ru.javarush.animal.Herbivorous;
import ru.javarush.parameter.Info;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Duck extends Herbivore implements Herbivorous {
    private static int maxQuantityLocation = Info.duckMaxQuantityLocation;

    public Duck() {
        super(4, 1, 0.15);
    }

    public static int getMaxQuantityLocation() {
        return maxQuantityLocation;
    }

    @Override
    public void eat(List<?> foodList, List<?> listFood) {
        try {
            if (this.getSaturation() < this.getSaturationMax()) {
                int chanceEat = ThreadLocalRandom.current().nextInt(0, 100);
                if (chanceEat > 10) {
                    double difference = this.getSaturationMax() - this.getSaturation();
                    if (foodList.size() > difference) {
                        this.setSaturation(this.getSaturationMax());
                        foodList.subList(0, (int) difference).clear();
                    }
                } else {
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
